package com.example.pointer.fragments.mainAdapterFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.databinding.FragmentSettingsMainBinding
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialSharedAxis
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsMainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsMainFragment : Fragment(R.layout.fragment_settings_main) {
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
    private val binding by viewBinding(FragmentSettingsMainBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            exitTransition = Hold()
            enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
            returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)
            myConsSettings.setOnClickListener {
                val extras = FragmentNavigatorExtras(myConsSettings to "settings")
                findNavController().navigate(R.id.settingsFragment, null, null, extras)
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
         * @return A new instance of fragment SettingsMainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingsMainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}