package com.example.pointer.fragments.payment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import at.markushi.ui.CircleButton
import com.example.pointer.R
import com.example.pointer.adapters.PaymeAdapter
import com.example.pointer.databinding.FragmentPaymentBinding
import com.example.pointer.models.Payme
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis
import java.util.*

class PaymentFragment : Fragment() {

    private lateinit var binding: FragmentPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPaymentBinding.inflate(inflater, container, false)
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
        sharedElementEnterTransition = MaterialContainerTransform()
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)

        binding.rv.adapter = PaymeAdapter(requireContext(), initList())
        return binding.root
    }

    private fun initList(): ArrayList<Payme> {

        val list: ArrayList<Payme> = ArrayList()

        for (i in 0..10)
        {
            list.add(
                Payme("Tushum", R.drawable.payme, "Naqd", "+1 200 000"))
        }

        return list
    }

}