package com.example.pointer.adapters.chat

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.R
import com.example.pointer.databinding.LayoutItemChatListBinding
import com.example.pointer.models.chat.ChatListItem
import com.example.pointer.utils.Convertor

class ChatListAdapter(var chatList: ArrayList<ChatListItem>, var navController: NavController) :
    RecyclerView.Adapter<ChatListAdapter.ChatListHolder>() {

    private lateinit var context: Context

    class ChatListHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = LayoutItemChatListBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_chat_list, parent, false)

        context = parent.context
        return ChatListHolder(view)
    }

    override fun onBindViewHolder(holder: ChatListHolder, position: Int) {
        val item = chatList[position]

        holder.binding.apply {
            chatNameTxt.text = item.chatName
            avaImg.setImageDrawable(item.avatar)
            lastMsgTxt.text = item.lastMessage
            lastMsgTime.text = Convertor.dateToStr(item.lastMessageSent, "hh:mm").toString()

            itemRoot.setOnClickListener {
                val data = Bundle()

                data.putString("name", item.chatName)
                data.putString("id1", item.id)
                data.putString("id2", item.id2)
                data.putByteArray("avatar", Convertor.drawableToByteArray(item.avatar))
                navController.navigate(R.id.messagesFragment, data)
            }
        }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }
}