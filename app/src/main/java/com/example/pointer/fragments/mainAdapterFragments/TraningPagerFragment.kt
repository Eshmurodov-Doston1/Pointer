package com.example.pointer.fragments.mainAdapterFragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.View
import android.view.animation.RotateAnimation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import at.markushi.ui.CircleButton
import com.example.pointer.R
import com.example.pointer.databinding.FragmentTraningPagerBinding
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialSharedAxis
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TraningPagerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TraningPagerFragment : Fragment(R.layout.fragment_traning_pager) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    private val binding by viewBinding(FragmentTraningPagerBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            exitTransition = Hold()
            enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
            returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)

            var handlerThread = Handler(Looper.getMainLooper())
            var mainMenuBtn = requireActivity().findViewById<CircleButton>(R.id.main_menu_btn)
            consTraining.setOnClickListener {
                handlerThread.postDelayed({
                    mainMenuBtn.setImageResource(R.drawable.ic_vector_3)
                    mainMenuBtn.setPadding(0,0,0,9)
                },490)
                var rotateAnimation = RotateAnimation(0F, 180F,
                    RotateAnimation.RELATIVE_TO_SELF,.5f,
                    RotateAnimation.RELATIVE_TO_SELF,.5f)
                rotateAnimation.duration = 450
                mainMenuBtn.startAnimation(rotateAnimation)
                val extras = FragmentNavigatorExtras(consTraining to "cons")
                findNavController().navigate(R.id.trainingMainFragment,null,null,extras)
            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TraningPagerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TraningPagerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}