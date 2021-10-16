package com.example.pointer.fragments.mainAdapterFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.mainAdapter.traning.TrainingMainPagerAdapter
import com.example.pointer.adapters.trainingAdapter.TrainingViewPagerAdapter
import com.example.pointer.databinding.FragmentTraningPagerBinding
import com.example.pointer.models.Training
import com.example.training.animations.DepthPageTransformer
import com.google.android.material.tabs.TabLayoutMediator
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
    lateinit var listCategory:ArrayList<String>
    lateinit var traningMainPagerAdapter:TrainingMainPagerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loadList()
            exitTransition = Hold()
            enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
            returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)


           traningMainPagerAdapter = TrainingMainPagerAdapter(requireActivity())
            binding.viewPager.adapter =traningMainPagerAdapter
            TabLayoutMediator(tablayout,viewPager){tab,position->
                tab.text = listCategory[position]
            }.attach()

            back.setOnClickListener {
                findNavController().popBackStack()
            }
            consTraining.setOnClickListener {
                val extras = FragmentNavigatorExtras(consTraining to "cons")
                findNavController().navigate(R.id.trainingMainFragment,null,null,extras)
            }
        }
    }

    private fun loadList() {
        listCategory = ArrayList()
        listCategory.add("O'tgan")
        listCategory.add("Hozirgi")
        listCategory.add("Kutilayotgan")

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