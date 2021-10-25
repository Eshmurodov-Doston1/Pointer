package com.example.pointer.fragments.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.databinding.FragmentChatBinding
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class ChatFragment() : Fragment(R.layout.fragment_chat) {
    private val binding by viewBinding(FragmentChatBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            sharedElementEnterTransition = MaterialContainerTransform()
            enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
            returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)

            childFragmentManager.beginTransaction().replace(R.id.frame, ChatListFragment()).commit()
        }
    }
}