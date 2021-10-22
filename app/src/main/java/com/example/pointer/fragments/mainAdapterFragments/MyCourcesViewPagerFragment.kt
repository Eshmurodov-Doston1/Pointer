package com.example.pointer.fragments.mainAdapterFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.CompositePageTransformer
import com.example.pointer.R
import com.example.pointer.adapters.courseViewPager.CourseViewPagerAdapter
import com.example.pointer.adapters.mainAdapter.studentAdapter.ViewPagerAdapterCourse
import com.example.pointer.databinding.FragmentMyCourcesViewPagerBinding
import com.example.pointer.databinding.ItemCourseStudentBinding
import com.example.pointer.models.student.StudentCourse
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyCourcesViewPagerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyCourcesViewPagerFragment : Fragment(R.layout.fragment_my_cources_view_pager) {
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
    private val binding by viewBinding(FragmentMyCourcesViewPagerBinding::bind)
    lateinit var courseViewPagerAdapter: ViewPagerAdapterCourse
    lateinit var listCource:ArrayList<StudentCourse>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
//            loadCource()
//            courseViewPagerAdapter = ViewPagerAdapterCourse(requireContext())
//            courseViewPagerAdapter.submitList(listCource)
//            courceViewPager.adapter = courseViewPagerAdapter
//
//            courceViewPager.clipToPadding=false
//            courceViewPager.clipChildren=false
//            courceViewPager.offscreenPageLimit=listCource.size
//            var transformer = CompositePageTransformer()
//            transformer.addTransformer { page, position ->
//                var a= 1-Math.abs(position)
//                page.scaleY = 0.85F+a*0.1f
//            }
//            courceViewPager.setPageTransformer(transformer)
//
            button.setOnClickListener {
                val extras = FragmentNavigatorExtras(button to "view")
                findNavController().navigate(R.id.myCourceFragment,null,null,extras)
            }
        }
    }

    private fun loadCource() {
        listCource = ArrayList()
        listCource.add(StudentCourse("UI/UX darslari","https://storage.myseldon.com/news_pict_CD/CDA66099E6144A1C0294E9BEE69A0D88","https://im0-tub-com.yandex.net/i?id=6cf5843522c5c3b4eb75f2b57f7957fe&n=13","Sanjar Suvonov","UI/UX",40))
        listCource.add(StudentCourse("UI/UX darslari","https://storage.myseldon.com/news_pict_CD/CDA66099E6144A1C0294E9BEE69A0D88","https://im0-tub-com.yandex.net/i?id=6cf5843522c5c3b4eb75f2b57f7957fe&n=13","Sanjar Suvonov","UI/UX",40))
        listCource.add(StudentCourse("UI/UX darslari","https://storage.myseldon.com/news_pict_CD/CDA66099E6144A1C0294E9BEE69A0D88","https://im0-tub-com.yandex.net/i?id=6cf5843522c5c3b4eb75f2b57f7957fe&n=13","Sanjar Suvonov","UI/UX",40))
        listCource.add(StudentCourse("UI/UX darslari","https://storage.myseldon.com/news_pict_CD/CDA66099E6144A1C0294E9BEE69A0D88","https://im0-tub-com.yandex.net/i?id=6cf5843522c5c3b4eb75f2b57f7957fe&n=13","Sanjar Suvonov","UI/UX",40))
        listCource.add(StudentCourse("UI/UX darslari","https://storage.myseldon.com/news_pict_CD/CDA66099E6144A1C0294E9BEE69A0D88","https://im0-tub-com.yandex.net/i?id=6cf5843522c5c3b4eb75f2b57f7957fe&n=13","Sanjar Suvonov","UI/UX",40))
        listCource.add(StudentCourse("UI/UX darslari","https://storage.myseldon.com/news_pict_CD/CDA66099E6144A1C0294E9BEE69A0D88","https://im0-tub-com.yandex.net/i?id=6cf5843522c5c3b4eb75f2b57f7957fe&n=13","Sanjar Suvonov","UI/UX",40))
        listCource.add(StudentCourse("UI/UX darslari","https://storage.myseldon.com/news_pict_CD/CDA66099E6144A1C0294E9BEE69A0D88","https://im0-tub-com.yandex.net/i?id=6cf5843522c5c3b4eb75f2b57f7957fe&n=13","Sanjar Suvonov","UI/UX",40))

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyCourcesViewPagerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyCourcesViewPagerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}