package com.example.pointer.fragments.videoCources

import android.os.Bundle
import android.transition.ChangeBounds
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import at.markushi.ui.CircleButton
import com.example.pointer.R
import com.example.pointer.adapters.pointerCources.PointerCourcesAdapter
import com.example.pointer.databinding.FragmentAllVideoCourseBinding
import com.example.pointer.databinding.ItemCourseAdapterBinding
import com.example.pointer.models.videocources.Programming
import com.example.pointer.models.videocources.VideoCourse
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AllVideoCourseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AllVideoCourseFragment : Fragment(R.layout.fragment_all_video_course) {
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

    private val binding by viewBinding(FragmentAllVideoCourseBinding::bind)
    lateinit var pointerCourcesAdapter: PointerCourcesAdapter
    lateinit var listProgramm: ArrayList<Programming>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            requireActivity().findViewById<CircleButton>(R.id.main_menu_btn).visibility = View.GONE
            requireActivity().findViewById<ImageView>(R.id.line).visibility = View.GONE
            sharedElementEnterTransition = ChangeBounds()
            val videoCourse = arguments?.getSerializable("videoCourse") as VideoCourse
            clouse.setOnClickListener {
                findNavController().popBackStack()
            }
            loadProgramming()
            pageName.text = videoCourse.name
            nameCourse.text = videoCourse.name
            countCourse.text = "Kurs Davomiyligi ${videoCourse.videoCourseNumber} oy"
            nameCourseSi.text = videoCourse.shortNameCourse
            info.text =
                "Assalomu aleykum kursimizga xush kelibsiz siz bu kurs orqali o'zingizga yoqqan kasbni eggalashingiz mumkin buning uchun siz quyida ko'rsatilgan texnalogiyalarni o'rganishingiz kerak"
            if (videoCourse.name.lowercase(Locale.getDefault()) == "Android Dasturlash".lowercase(
                    Locale.getDefault()
                )
            ) {
                pointerCourcesAdapter =
                    PointerCourcesAdapter(object : PointerCourcesAdapter.OnCourseClick {
                        override fun onCourseClic(
                            programming: Programming,
                            position: Int,
                            itemCourseAdapterBinding: ItemCourseAdapterBinding
                        ) {
                            var extras: FragmentNavigator.Extras =
                                FragmentNavigator.Extras.Builder()
                                    .addSharedElement(itemCourseAdapterBinding.cons, "consItem")
                                    .build()
                            findNavController().navigate(R.id.createPDFFragment, null, null, extras)
                        }
                    })
                pointerCourcesAdapter.submitList(listProgramm)
                rvCourse.adapter = pointerCourcesAdapter

            }
        }
    }

    private fun loadProgramming() {
        listProgramm = ArrayList()
        listProgramm.add(
            Programming(
                "Java",
                "Kurs Davomiyligi 3 oy",
                "https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/0a/8cd7f1b14344618b75142593bc7af8/JavaCupLogo800x800.png?auto=format%2Ccompress&dpr=1"
            )
        )
        listProgramm.add(
            Programming(
                "Kotlin",
                "Kurs Davomiyligi 2 hafta",
                "https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/e3/f27630d13511e88dd241e68ded0cea/K_logo_800x800.png?auto=format%2Ccompress&dpr=1"
            )
        )
        listProgramm.add(
            Programming(
                "Android",
                "Kurs Davomiyligi 5 oy",
                "https://cdn.vox-cdn.com/thumbor/4YrhF65YGLd8OjHv-y8D_zJH4bI=/0x0:2040x1560/1400x933/filters:focal(857x617:1183x943):no_upscale()/cdn.vox-cdn.com/uploads/chorus_image/image/65088839/Android_logo_stacked__RGB_.5.jpg"
            )
        )
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AllVideoCourseFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AllVideoCourseFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}