package com.example.pointer.fragments.student

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.CompositePageTransformer
import at.markushi.ui.CircleButton
import com.example.pointer.R
import com.example.pointer.adapters.courseViewPager.CourseViewPagerAdapter
import com.example.pointer.databinding.FragmentMyCourceBinding
import com.example.pointer.databinding.ItemCourseStudentBinding
import com.example.pointer.models.student.StudentCourse
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyCourceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyCourceFragment : Fragment(R.layout.fragment_my_cource) {
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

    private val binding by viewBinding(FragmentMyCourceBinding::bind)
    lateinit var courseViewPagerAdapter: CourseViewPagerAdapter
    lateinit var listCource: ArrayList<StudentCourse>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedElementEnterTransition = MaterialContainerTransform()
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)
        binding.apply {
            loadCource()

            courseViewPagerAdapter = CourseViewPagerAdapter(requireContext(),
                object : CourseViewPagerAdapter.OnItemClickListener {
                    override fun onItemClick(
                        studentCourse: StudentCourse,
                        position: Int,
                        itemCourceStudentBinding: ItemCourseStudentBinding
                    ) {
                        var extras: FragmentNavigator.Extras = FragmentNavigator.Extras.Builder()
                            .addSharedElement(itemCourceStudentBinding.myCons, "my_image")
                            .build()
                        var bundle = Bundle()
                        bundle.putSerializable("studentCource", studentCourse)
                        findNavController().navigate(
                            R.id.studentInformationFragment,
                            bundle,
                            null,
                            extras
                        )
                    }

                })
            courseViewPagerAdapter.submitList(listCource)
            courceViewPager.adapter = courseViewPagerAdapter

            courceViewPager.clipToPadding = false
            courceViewPager.clipChildren = false
            courceViewPager.offscreenPageLimit = listCource.size
            var transformer = CompositePageTransformer()
            transformer.addTransformer { page, position ->
                var a = 1 - Math.abs(position)
                page.scaleY = 0.85F + a * 0.1f
            }
            courceViewPager.setPageTransformer(transformer)

        }
    }

    private fun loadCource() {
        listCource = ArrayList()
        listCource.add(
            StudentCourse(
                "UI/UX darslari",
                "https://storage.myseldon.com/news_pict_CD/CDA66099E6144A1C0294E9BEE69A0D88",
                "https://im0-tub-com.yandex.net/i?id=6cf5843522c5c3b4eb75f2b57f7957fe&n=13",
                "Sanjar Suvonov",
                "UI/UX",
                40
            )
        )
        listCource.add(
            StudentCourse(
                "UI/UX darslari",
                "https://storage.myseldon.com/news_pict_CD/CDA66099E6144A1C0294E9BEE69A0D88",
                "https://im0-tub-com.yandex.net/i?id=6cf5843522c5c3b4eb75f2b57f7957fe&n=13",
                "Sanjar Suvonov",
                "UI/UX",
                40
            )
        )
        listCource.add(
            StudentCourse(
                "UI/UX darslari",
                "https://storage.myseldon.com/news_pict_CD/CDA66099E6144A1C0294E9BEE69A0D88",
                "https://im0-tub-com.yandex.net/i?id=6cf5843522c5c3b4eb75f2b57f7957fe&n=13",
                "Sanjar Suvonov",
                "UI/UX",
                40
            )
        )
        listCource.add(
            StudentCourse(
                "UI/UX darslari",
                "https://storage.myseldon.com/news_pict_CD/CDA66099E6144A1C0294E9BEE69A0D88",
                "https://im0-tub-com.yandex.net/i?id=6cf5843522c5c3b4eb75f2b57f7957fe&n=13",
                "Sanjar Suvonov",
                "UI/UX",
                40
            )
        )
        listCource.add(
            StudentCourse(
                "UI/UX darslari",
                "https://storage.myseldon.com/news_pict_CD/CDA66099E6144A1C0294E9BEE69A0D88",
                "https://im0-tub-com.yandex.net/i?id=6cf5843522c5c3b4eb75f2b57f7957fe&n=13",
                "Sanjar Suvonov",
                "UI/UX",
                40
            )
        )
        listCource.add(
            StudentCourse(
                "UI/UX darslari",
                "https://storage.myseldon.com/news_pict_CD/CDA66099E6144A1C0294E9BEE69A0D88",
                "https://im0-tub-com.yandex.net/i?id=6cf5843522c5c3b4eb75f2b57f7957fe&n=13",
                "Sanjar Suvonov",
                "UI/UX",
                40
            )
        )
        listCource.add(
            StudentCourse(
                "UI/UX darslari",
                "https://storage.myseldon.com/news_pict_CD/CDA66099E6144A1C0294E9BEE69A0D88",
                "https://im0-tub-com.yandex.net/i?id=6cf5843522c5c3b4eb75f2b57f7957fe&n=13",
                "Sanjar Suvonov",
                "UI/UX",
                40
            )
        )
    }

    override fun onResume() {
        super.onResume()
        if (requireActivity().findViewById<CircleButton>(R.id.main_menu_btn).visibility == View.GONE) {
            requireActivity().findViewById<CircleButton>(R.id.main_menu_btn).visibility =
                View.VISIBLE
            requireActivity().findViewById<ImageView>(R.id.line).visibility = View.VISIBLE
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyCourceFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyCourceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}