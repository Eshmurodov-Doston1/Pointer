package com.example.pointer.fragments.chat

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import at.markushi.ui.CircleButton
import com.example.pointer.R
import com.example.pointer.adapters.chat.ChatListAdapter
import com.example.pointer.databinding.FragmentChatListBinding
import com.example.pointer.models.chat.ChatListItem
import com.example.pointer.navButton
import com.example.pointer.navLine
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class ChatListFragment : Fragment(R.layout.fragment_chat_list) {
    private val chats: ArrayList<ChatListItem> = arrayListOf()
    private val binding by viewBinding(FragmentChatListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val handlerThread = Handler(Looper.getMainLooper())
        val mainMenuBtn = requireActivity().findViewById<CircleButton>(R.id.main_menu_btn)
        handlerThread.postDelayed({
            mainMenuBtn.setImageResource(R.drawable.ic_vector_3)
            mainMenuBtn.setPadding(0, 0, 0, 9)
        }, 490)
        val rotateAnimation = RotateAnimation(
            0F,
            180F,
            RotateAnimation.RELATIVE_TO_SELF,
            .5f,
            RotateAnimation.RELATIVE_TO_SELF,
            .5f
        )
        rotateAnimation.duration = 450
        mainMenuBtn.startAnimation(rotateAnimation)
        binding.apply {

            sharedElementEnterTransition = MaterialContainerTransform()
            enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true)
            returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, false)
            navLine.visibility = View.VISIBLE
            navButton.visibility = View.VISIBLE

            chats.clear()
            chats.add(
                ChatListItem(
                    "1000",
                    "1001",
                    "Po‘lat Alendar",
                    context?.getDrawable(R.drawable.pulat)!!
                )
            )
            chats.add(
                ChatListItem(
                    "1001",
                    "1000",
                    "Anonymous",
                    context?.getDrawable(R.drawable.anonymous)!!
                )
            )

            binding.apply {
                val adapter = ChatListAdapter(chats, findNavController())

                chatList.adapter = adapter
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (requireActivity().findViewById<ImageView>(R.id.line).visibility ==View.GONE){
            requireActivity().findViewById<ImageView>(R.id.line).visibility =View.VISIBLE
            requireActivity().findViewById<CircleButton>(R.id.main_menu_btn).visibility =View.VISIBLE
        }
    }
}