package com.example.pointer.utils.chat

import com.example.pointer.models.chat.ChatMessage
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DataConnector(id1: String, id2: String) {
    private val base = FirebaseDatabase.getInstance().reference.child("chat-base").child("users")
    private val data1 = base.child(id1).child("data")
    private val data2 = base.child(id2).child("data")
    private lateinit var valueListener: ValueEventListener
    private var messageCount = 0

    fun startReadingMessages(onRead: (messages: ArrayList<ChatMessage>) -> Unit) {
        valueListener = object : ValueEventListener {
            override fun onDataChange(ds: DataSnapshot) {
                val messages: ArrayList<ChatMessage> = arrayListOf()

                messageCount = 0
                ds.children.forEachIndexed { i, dS ->
                    val message = ChatMessage()

                    message.id = dS.key!!
                    message.messageText = dS.child("text").value.toString()
                    message.sentTime = dS.child("sent_time").value.toString().toLong()
                    message.isSender = dS.child("is_sender").value.toString() == "1"

                    messages.add(message)
                    messageCount++
                }

                onRead(messages)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }


        data1.addValueEventListener(valueListener)
    }

    fun sendMessage(messageText: String) {
        val messageData: HashMap<String, String> = hashMapOf()

        messageData.put("is_sender", "1")
        messageData.put("text", messageText)
        messageData.put("sent_time", System.currentTimeMillis().toString())

        data1.child("${messageCount + 1}").setValue(messageData)
        messageData.put("is_sender", "0")
        data2.child("${messageCount + 1}").setValue(messageData)
    }

    fun close() {
        data1.removeEventListener(valueListener)
    }
}