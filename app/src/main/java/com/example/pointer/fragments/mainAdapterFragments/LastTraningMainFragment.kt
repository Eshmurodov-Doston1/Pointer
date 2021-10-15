package com.example.pointer.fragments.mainAdapterFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import com.example.pointer.R
import com.example.pointer.adapters.mainAdapter.traning.RvTraning
import com.example.pointer.databinding.FragmentLastTraningMainBinding
import com.example.pointer.models.Training
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LastTraningMainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LastTraningMainFragment : Fragment(R.layout.fragment_last_traning_main) {
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
    private val binding by viewBinding(FragmentLastTraningMainBinding::bind)
    lateinit var listTraining:ArrayList<Training>
    lateinit var rvTraining:RvTraning
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loadList()
            rvTraining = RvTraning(listTraining)
            rv.adapter = rvTraining
        }
    }

    private fun loadList() {
        listTraining = ArrayList()
        listTraining.add(
            Training( R.drawable.image20, "UX/UI bo’yicha master klass", "25.09.2021 12:00",
                "Pointers academy", R.drawable.oval, "Bektayev Asadbek", "Onlayn", "200 ta joy")
        )
        listTraining.add(
            Training( R.drawable.image20, "UX/UI bo’yicha master klass", "25.09.2021 12:00",
                "Pointers academy", R.drawable.oval, "Bektayev Asadbek", "Onlayn", "200 ta joy")
        )
        listTraining.add(
            Training( R.drawable.image20, "UX/UI bo’yicha master klass", "25.09.2021 12:00",
                "Pointers academy", R.drawable.oval, "Bektayev Asadbek", "Onlayn", "200 ta joy")
        )
        listTraining.add(
            Training( R.drawable.image20, "UX/UI bo’yicha master klass", "25.09.2021 12:00",
                "Pointers academy", R.drawable.oval, "Bektayev Asadbek", "Onlayn", "200 ta joy")
        )
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LastTraningMainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LastTraningMainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}