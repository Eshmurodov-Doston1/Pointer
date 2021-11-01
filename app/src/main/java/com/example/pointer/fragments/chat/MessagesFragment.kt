package com.example.pointer.fragments.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pointer.R
import com.example.pointer.adapters.chat.ChatMessagesAdapter
import com.example.pointer.databinding.FragmentChatMessagesBinding
import com.example.pointer.models.chat.ChatListItem
import com.example.pointer.navButton
import com.example.pointer.navLine
import com.example.pointer.utils.Convertor
import com.example.pointer.utils.chat.DataConnector

class MessagesFragment : Fragment(R.layout.fragment_chat_messages) {
    private lateinit var binding: FragmentChatMessagesBinding
    private lateinit var connector: DataConnector
    private lateinit var chat: ChatListItem

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentChatMessagesBinding.inflate(inflater)
        chat = ChatListItem(
            arguments?.getString("id1", "")!!,
            arguments?.getString("id2", "")!!,
            arguments?.getString("name", "")!!,
            Convertor.byteArrayToDrawable(context, arguments?.getByteArray("avatar"))
        )
        connector = DataConnector(chat.id, chat.id2)

        navLine.visibility = View.GONE
        navButton.visibility = View.GONE

        binding.apply {
            ivAva.setImageDrawable(chat.avatar)
            tvName.text = chat.chatName

            connector.startReadingMessages {
                lvMessages.adapter = ChatMessagesAdapter(it)
            }

            btnSend.setOnClickListener {
                connector.sendMessage(inputMessageText.text.toString())
                inputMessageText.setText("")
            }
        }

        return binding.root
    }
}