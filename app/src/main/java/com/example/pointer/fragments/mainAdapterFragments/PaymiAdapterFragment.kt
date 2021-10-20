package com.example.pointer.fragments.mainAdapterFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.PaymeAdapter
import com.example.pointer.adapters.mainAdapter.paymiAdapter.PaymiAdapter
import com.example.pointer.databinding.FragmentPaymiAdapterBinding
import com.example.pointer.models.Payme
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialSharedAxis
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PaymiAdapterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PaymiAdapterFragment : Fragment(R.layout.fragment_paymi_adapter) {
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
    private val binding by viewBinding(FragmentPaymiAdapterBinding::bind)
    lateinit var paymeAdapter:PaymiAdapter
    lateinit var listPayme:ArrayList<Payme>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loadList()
            exitTransition = Hold()
            enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
            returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)

            paymeAdapter = PaymiAdapter()
            paymeAdapter.submitList(listPayme)
            rvMy.adapter = paymeAdapter
            myCons1.setOnClickListener {
                val extras = FragmentNavigatorExtras(myCons1 to "payme")
                findNavController().navigate(R.id.paymeFragment, null, null, extras)
            }
        }
    }

    private fun loadList() {
        listPayme = ArrayList()
        for (i in 0..10)
        {
            listPayme.add(
                Payme("Tushum", R.drawable.payme, "Naqd", "+1 200 000"))
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PaymiAdapterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PaymiAdapterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}