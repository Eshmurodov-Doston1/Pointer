package com.example.pointer.fragments.student

import android.graphics.Color
import android.os.Bundle
import android.transition.ChangeBounds
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import at.markushi.ui.CircleButton
import com.example.pointer.R
import com.example.pointer.adapters.courseViewPager.ExpansionCourseAdapter
import com.example.pointer.databinding.ChildItemBinding
import com.example.pointer.databinding.FragmentStudentInformationBinding
import com.example.pointer.databinding.ItemRvBinding
import com.example.pointer.models.student.Course
import com.example.pointer.models.student.StudentCourse
import com.squareup.picasso.Picasso
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StudentInformationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentInformationFragment : Fragment(R.layout.fragment_student_information) {
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


    private val binding by viewBinding(FragmentStudentInformationBinding::bind)
    lateinit var expansionCourseAdapter: ExpansionCourseAdapter
    lateinit var listCourse: ArrayList<Course>
    lateinit var listCourseChild: ArrayList<String>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loadCourse1()
            loadCourse()

            sharedElementEnterTransition = ChangeBounds()
            requireActivity().findViewById<CircleButton>(R.id.main_menu_btn).visibility = View.GONE
            requireActivity().findViewById<ImageView>(R.id.line).visibility = View.GONE
            requireActivity().window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            val studentCourse = arguments?.getSerializable("studentCource") as StudentCourse
            Picasso.get().load(studentCourse.image).into(myImage)
            nameCourse.text = studentCourse.name
            countCourse.text = "${studentCourse.videoCourseNumber} ta dars"
            nameCourseSi.text = studentCourse.shortNameCourse
            Picasso.get().load(studentCourse.teacherImage).into(imageTeacher)
            teacherName.text = studentCourse.teacherName
            fullName.text = studentCourse.name

            expansionCourseAdapter =
                ExpansionCourseAdapter(object : ExpansionCourseAdapter.OnItemClickListener {
                    override fun onItemExpansionClick(
                        course: Course,
                        position: Int,
                        bool: Boolean,
                        itemRvBinding: ItemRvBinding
                    ) {
                        if (bool) {
                            itemRvBinding.myLine.setBackgroundColor(Color.WHITE)
                            itemRvBinding.name.setTextColor(Color.parseColor("#01D8D0"))
                            itemRvBinding.iconP.setImageResource(R.drawable.ic_vector1)
                        } else {
                            itemRvBinding.myLine.setBackgroundColor(Color.WHITE)
                            itemRvBinding.name.setTextColor(Color.BLACK)
                            itemRvBinding.iconP.setImageResource(R.drawable.ic_vector)
                        }
                    }
                }, object : ExpansionCourseAdapter.OnChildClick {
                    override fun onChildClick(str: String, childItemBinding: ChildItemBinding) {
                        var extras: FragmentNavigator.Extras = FragmentNavigator.Extras.Builder()
                            .addSharedElement(childItemBinding.childCard, "card")
                            .build()
                        var bundle = Bundle()
                        findNavController().navigate(
                            R.id.action_studentInformationFragment_to_courseFragment,
                            null,
                            null,
                            extras
                        )
                    }
                })
            clouse.setOnClickListener {
                findNavController().popBackStack()
            }
            expansionCourseAdapter.submitList(listCourse)
            rvCourse.adapter = expansionCourseAdapter
            rvCourse.isNestedScrollingEnabled = false
        }
    }

    private fun loadCourse1() {
        listCourseChild = ArrayList()
        listCourseChild.add("1-Dars")
        listCourseChild.add("2-Dars")
        listCourseChild.add("3-Dars")
        listCourseChild.add("4-Dars")
    }

    private fun loadCourse() {
        listCourse = ArrayList()
        listCourse.add(Course("Androidga Kirish", listCourseChild))
        listCourse.add(Course("Androidga Kirish", listCourseChild))
        listCourse.add(Course("Androidga Kirish", listCourseChild))
        listCourse.add(Course("Androidga Kirish", listCourseChild))
        listCourse.add(Course("Androidga Kirish", listCourseChild))
        listCourse.add(Course("Androidga Kirish", listCourseChild))
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StudentInformationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StudentInformationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}