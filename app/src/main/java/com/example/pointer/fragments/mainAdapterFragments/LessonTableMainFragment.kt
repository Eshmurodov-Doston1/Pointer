package com.example.pointer.fragments.mainAdapterFragments

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.RotateAnimation
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import at.markushi.ui.CircleButton
import com.example.pointer.R
import com.example.pointer.adapters.TableRecyclerAdapter
import com.example.pointer.databinding.FragmentLessonTableMainBinding
import com.example.pointer.models.Table
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialSharedAxis
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LessonTableMainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LessonTableMainFragment : Fragment(R.layout.fragment_lesson_table_main) {
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
    private val binding by viewBinding(FragmentLessonTableMainBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            exitTransition = Hold()
            enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
            returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)

            var handlerThread = Handler(Looper.getMainLooper())

            var mainMenuBtn = requireActivity().findViewById<CircleButton>(R.id.main_menu_btn)

            cons1.setOnClickListener {
                handlerThread.postDelayed({
                    mainMenuBtn.setImageResource(R.drawable.ic_vector_3)
                    mainMenuBtn.setPadding(0,0,0,9)
                },490)
                var rotateAnimation = RotateAnimation(0F, 180F,
                    RotateAnimation.RELATIVE_TO_SELF,.5f,
                    RotateAnimation.RELATIVE_TO_SELF,.5f)
                rotateAnimation.duration = 450
                mainMenuBtn.startAnimation(rotateAnimation)
                val extras = FragmentNavigatorExtras(cons1 to "my_calendar")
                findNavController().navigate(R.id.calendarFragment,null,null,extras)
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
         * @return A new instance of fragment LessonTableMainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LessonTableMainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}