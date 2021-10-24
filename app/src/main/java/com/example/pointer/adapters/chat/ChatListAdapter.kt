package com.example.pointer.adapters.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.R
import com.example.pointer.databinding.LayoutItemChatListBinding
import com.example.pointer.models.chat.ChatListItem
import com.example.pointer.utils.TimeEncoder

class ChatListAdapter(var chatList: ArrayList<ChatListItem>) : RecyclerView.Adapter<ChatListAdapter.ChatListHolder>() {

    class ChatListHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = LayoutItemChatListBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_chat_list, parent, false)
        return ChatListHolder(view)
    }

    override fun onBindViewHolder(holder: ChatListHolder, position: Int) {
        val item = chatList[position]

        holder.binding.apply {
            chatNameTxt.text = item.chatName
            avaImg.setImageDrawable(item.avatar)
            lastMsgTxt.text = item.lastMessage
            lastMsgTime.text = TimeEncoder.dateToStr(item.lastMessageSent, "hh:mm").toString()
        }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }
}