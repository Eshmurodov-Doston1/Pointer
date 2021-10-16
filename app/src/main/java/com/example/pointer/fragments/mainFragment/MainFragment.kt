package com.example.pointer.fragments.mainFragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.mainAdapter.MainViewPagerAdapter
import com.example.pointer.databinding.FragmentMainBinding
import com.example.pointer.databinding.ItemTabMainBinding
import com.google.android.material.tabs.TabLayout
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
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment(R.layout.fragment_main) {
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
    private val binding by viewBinding(FragmentMainBinding::bind)
    lateinit var mainViewPagerAdapter:MainViewPagerAdapter
    lateinit var listLoad:ArrayList<String>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loadList()
            mainViewPagerAdapter = MainViewPagerAdapter(requireActivity())
            viewPager.adapter = mainViewPagerAdapter
            viewPager.clipToPadding=false
            viewPager.clipChildren=false


            exitTransition = Hold()
            enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
            returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)


            mainBtn.setOnClickListener {
                when(viewPager.currentItem){
                    0->{
                        val extras = FragmentNavigatorExtras(mainBtn to "cardView")
                        findNavController().navigate(R.id.videoCourcesFragment, null, null, extras)
                    }
                    1->{
                        val extras = FragmentNavigatorExtras(mainBtn to "cardView")
                        findNavController().navigate(R.id.myCourceFragment, null, null, extras)
                    }
                    2->{
                        val extras = FragmentNavigatorExtras(mainBtn to "cardView")
                        findNavController().navigate(R.id.newsFragment, null, null, extras)
                    }
                    3->{
                        val extras = FragmentNavigatorExtras(mainBtn to "cardView")
                        findNavController().navigate(R.id.trainingMainFragment, null, null, extras)
                    }
                    4->{
                        val extras = FragmentNavigatorExtras(mainBtn to "cardView")
                        findNavController().navigate(R.id.myGroupFragment, null, null, extras)
                    }
                    5->{
                        val extras = FragmentNavigatorExtras(mainBtn to "cardView")
                        findNavController().navigate(R.id.calendarFragment, null, null, extras)
                    }
                    6->{

                    }
                    7->{

                    }
                    8->{
                        val extras = FragmentNavigatorExtras(mainBtn to "cardView")
                        findNavController().navigate(R.id.paymeFragment, null, null, extras)
                    }

                }
            }


            viewPager.offscreenPageLimit = 2
            viewPager.setPageTransformer { page, position ->
                var a= 1-Math.abs(position)
                page.scaleY = 0.85F+a*0.1f
            }
            TabLayoutMediator(tabLayout,viewPager){ tab,position->
                tab.text = listLoad[position]
            }.attach()
            setTabs()
            tabLayout.clipToPadding =false
            tabLayout.clipChildren = false
            tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val customView = tab!!.customView
                    val let = customView?.let { ItemTabMainBinding.bind(it) }
                    let?.name?.setTextColor(Color.parseColor("#01D8D0"))
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    val customView = tab!!.customView
                    val let = customView?.let { ItemTabMainBinding.bind(it) }
                    let?.name?.setTextColor(Color.parseColor("#BDBDBD"))
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

            })
        }
    }



    private fun setTabs() {
        val tabCount = binding.tabLayout.tabCount
        for (i in 0 until tabCount){
            var itemTabBinding = ItemTabMainBinding.inflate(LayoutInflater.from(requireContext()),null,false)
            val tabAt = binding.tabLayout.getTabAt(i)
            tabAt?.customView = itemTabBinding.root
            itemTabBinding.name.text = listLoad[i]
            if (i==0){
                itemTabBinding.name.setTextColor(Color.parseColor("#01D8D0"))
            }else{
                itemTabBinding.name.setTextColor(Color.parseColor("#BDBDBD"))
            }
        }
    }

    private fun loadList() {
        listLoad = ArrayList()
        listLoad.add("Asosiy")
        listLoad.add("Mening kurslarim ")
        listLoad.add("Yangiliklar")
        listLoad.add("Traninglar")
        listLoad.add("Mening guruhim")
        listLoad.add("Dars jadvali")
        listLoad.add("Chat")
        listLoad.add("Sozlamalar")
        listLoad.add("To'lov")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
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