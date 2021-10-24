package com.example.pointer.fragments.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pointer.R
import com.example.pointer.adapters.chat.ChatListAdapter
import com.example.pointer.databinding.FragmentChatListBinding
import com.example.pointer.models.chat.ChatListItem

class ChatListFragment : Fragment(R.layout.fragment_chat_list) {
    private val chats: ArrayList<ChatListItem> = arrayListOf()

    private lateinit var binding: FragmentChatListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentChatListBinding.inflate(inflater)
        chats.add(ChatListItem("1000", "Po‘lat Alendar", context?.getDrawable(R.drawable.pulat)!!))
        chats.add(ChatListItem("1001", "Anonymous", context?.getDrawable(R.drawable.anonymous)!!))

        binding.apply {
            val adapter = ChatListAdapter(chats)

            chatList.adapter = adapter
        }
        return binding.root
    }
}