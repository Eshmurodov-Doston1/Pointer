package com.example.pointer.adapters.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.R
import com.example.pointer.databinding.LayoutMessageRecvBinding
import com.example.pointer.databinding.LayoutMessageSentBinding
import com.example.pointer.models.chat.ChatMessage
import com.example.pointer.utils.Convertor

class ChatMessagesAdapter(private var messages: ArrayList<ChatMessage>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val IS_SENT = 0
    private val IS_RECEIVED = 1

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].isSender) {
            IS_SENT
        } else {
            IS_RECEIVED
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View

        return if (viewType == IS_SENT) {
            view = inflater.inflate(R.layout.layout_message_sent, parent, false)
            SentMessageViewHolder(view)
        } else {
            view = inflater.inflate(R.layout.layout_message_recv, parent, false)
            RecvMessageViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == IS_SENT) {
            val h = holder as SentMessageViewHolder

            h.binding.tvMsgTxt.text = messages[position].messageText
            h.binding.tvMsgSentTime.text = Convertor.dateToStr(messages[position].sentTime, "HH:mm")
        } else {
            val h = holder as RecvMessageViewHolder

            h.binding.tvMsgTxt.text = messages[position].messageText
            h.binding.tvMsgSentTime.text = Convertor.dateToStr(messages[position].sentTime, "HH:mm")
        }
    }

    override fun getItemCount() = messages.size

    class SentMessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = LayoutMessageSentBinding.bind(itemView)
    }

    class RecvMessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = LayoutMessageRecvBinding.bind(itemView)
    }
}