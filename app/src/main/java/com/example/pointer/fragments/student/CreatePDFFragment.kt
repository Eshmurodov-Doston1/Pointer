package com.example.pointer.fragments.student

import android.os.Bundle
import android.transition.ChangeBounds
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.databinding.FragmentCreatePDFBinding
import com.github.barteksc.pdfviewer.PDFView
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreatePDFFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreatePDFFragment : Fragment(R.layout.fragment_create_p_d_f) {
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
    private val binding by viewBinding(FragmentCreatePDFBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            sharedElementEnterTransition = ChangeBounds()
           myPdf.fromAsset("resum.pdf").load()
            close.setOnClickListener {
                findNavController().popBackStack()
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
         * @return A new instance of fragment CreatePDFFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreatePDFFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}