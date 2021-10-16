package com.example.pointer.fragments.mainAdapterFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.mainAdapter.group.MyMainGroupAdapter
import com.example.pointer.databinding.FragmentMyMainGroupBinding
import com.example.pointer.models.mygroup.MyGroup
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyMainGroupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyMainGroupFragment : Fragment(R.layout.fragment_my_main_group) {
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
    private val binding by viewBinding(FragmentMyMainGroupBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            binding.rv.adapter = MyMainGroupAdapter(requireContext(), initList()) {
                findNavController().navigate(R.id.studentFragment)
            }
        }
    }

    private fun initList(): ArrayList<MyGroup> {

        val list: ArrayList<MyGroup> = ArrayList()

        for (i in 0..10)
        {
            list.add(
                MyGroup("Asadbek Bektayev", R.drawable.news_image3, true)
            )
        }

        return list
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyMainGroupFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyMainGroupFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}