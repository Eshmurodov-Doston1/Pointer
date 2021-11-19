package com.example.pointer.fragments.chat

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import at.markushi.ui.CircleButton
import com.example.pointer.R
import com.example.pointer.adapters.chat.ChatMessagesAdapter
import com.example.pointer.databinding.FragmentChatMessagesBinding
import com.example.pointer.models.chat.ChatListItem
import com.example.pointer.navButton
import com.example.pointer.navLine
import com.example.pointer.utils.Convertor
import com.example.pointer.utils.chat.DataConnector
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat

import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController


class MessagesFragment : Fragment(R.layout.fragment_chat_messages) {
    private lateinit var binding: FragmentChatMessagesBinding
    private lateinit var connector: DataConnector
    private lateinit var chat: ChatListItem

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentChatMessagesBinding.inflate(inflater)

        requireActivity().findViewById<ImageView>(R.id.line).visibility =View.GONE
        requireActivity().findViewById<CircleButton>(R.id.main_menu_btn).visibility =View.GONE
        requireActivity().findViewById<CardView>(R.id.card_price).visibility =View.GONE
        requireActivity().findViewById<CardView>(R.id.card_chat).visibility =View.GONE



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


            var calback = object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val overlay = requireActivity().findViewById<ConstraintLayout>(R.id.container)
                    overlay.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
                    findNavController().popBackStack()
                }
            }
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, calback)

            connector.startReadingMessages {
                lvMessages.adapter = ChatMessagesAdapter(it)
            }

            btnSend.setOnClickListener {
                connector.sendMessage(inputMessageText.text.toString())
                inputMessageText.setText("")

                val overlay = requireActivity().findViewById<ConstraintLayout>(R.id.container)
                overlay.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            }
        }

        return binding.root
    }
}