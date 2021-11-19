package com.example.pointer.fragments.mainFragment


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.mainAdapter.MainViewPagerAdapter
import com.example.pointer.databinding.FragmentMainBinding
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialSharedAxis
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import kotlin.math.abs

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment(R.layout.fragment_main) {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private val binding by viewBinding(FragmentMainBinding::bind)
    lateinit var mainViewPagerAdapter: MainViewPagerAdapter
    lateinit var listLoad: ArrayList<String>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            loadList()
            exitTransition = Hold()
            enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
            returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)

            mainViewPagerAdapter = MainViewPagerAdapter(requireActivity())
            mainViewPager.adapter = mainViewPagerAdapter

            mainViewPager.clipToPadding = false
            mainViewPager.clipChildren = false

            mainViewPager.offscreenPageLimit = 1
            mainViewPager.setPageTransformer { page, position ->
                val a = 1 - abs(position)
                page.scaleY = 0.85F + a * 0.1f
            }

            card1.setOnClickListener {
                val extras = FragmentNavigatorExtras(card1 to "payment")
                findNavController().navigate(R.id.paymentFragment, null, null, extras)

            }

            card2.setOnClickListener {
                val extras = FragmentNavigatorExtras(card2 to "chat")
                findNavController().navigate(R.id.chatListFragment, null, null, extras)
            }

            card3.setOnClickListener {
                val extras = FragmentNavigatorExtras(card3 to "settings")
                findNavController().navigate(R.id.settingsFragment, null, null, extras)
            }
        }
    }

    private fun loadList() {
        listLoad = ArrayList()
        listLoad.add("Asosiy")
        listLoad.add("Mening kurslarim")
        listLoad.add("Yangiliklar")
        listLoad.add("Traninglar")
        listLoad.add("Mening guruhim")
        listLoad.add("Dars jadvali")
//        listLoad.add("Chat")
//        listLoad.add("Sozlamalar")
//        listLoad.add("To'lov")
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}