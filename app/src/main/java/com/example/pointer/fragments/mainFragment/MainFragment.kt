package com.example.pointer.fragments.mainFragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentContainer
import com.example.pointer.MainActivity
import com.example.pointer.R
import com.example.pointer.adapters.mainAdapter.MainViewPagerAdapter
import com.example.pointer.databinding.FragmentMainBinding
import com.example.pointer.models.interfaceMy.ButtonClick
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
            mainViewPager.adapter = mainViewPagerAdapter

            mainViewPager.clipToPadding=false
            mainViewPager.clipChildren=false
            
            exitTransition = Hold()
            enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
            returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)

            mainViewPager.offscreenPageLimit = 1
            mainViewPager.setPageTransformer { page, position ->
                var a= 1-Math.abs(position)
                page.scaleY = 0.85F+a*0.1f
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