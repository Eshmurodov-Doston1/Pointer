package com.example.pointer.fragments.videoCources

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import androidx.viewpager2.widget.CompositePageTransformer
import com.example.pointer.R
import com.example.pointer.adapters.vodeoCourseAdapters.PagerAdapterVideoCourse
import com.example.pointer.databinding.FragmentVideoCourcesBinding
import com.example.pointer.models.student.Course
import com.example.pointer.models.videocources.VideoCourse
import com.google.android.material.tabs.TabLayoutMediator
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VideoCourcesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VideoCourcesFragment : Fragment(R.layout.fragment_video_cources) {
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
    private val binding by viewBinding(FragmentVideoCourcesBinding::bind)
    lateinit var pagerAdapterVideoCourse:PagerAdapterVideoCourse
    lateinit var listCourse:ArrayList<VideoCourse>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loadCourse()
            pagerAdapterVideoCourse = PagerAdapterVideoCourse()

            pagerAdapterVideoCourse.submitList(listCourse)
            viewPager2.adapter = pagerAdapterVideoCourse
            viewPager2.clipToPadding=false
            viewPager2.clipChildren=false
            viewPager2.offscreenPageLimit = 3
            viewPager2.setPageTransformer { page, position ->
                var a= 1-Math.abs(position)
                page.scaleY = 0.85F+a*0.1f
            }
            TabLayoutMediator(tabLayout,viewPager2){ tab,position->
                tab.text = listCourse[position].name
            }.attach()
            tabLayout.clipChildren = false
            tabLayout.clipToPadding = false
        }
    }

    private fun loadCourse() {
        listCourse = ArrayList()
        listCourse.add(VideoCourse("Android kursi","https://tproger.ru/s3/uploads/2015/03/android-development-770x270.jpg","https://miro.medium.com/fit/c/262/262/1*MjhYbbidoKrR3CNN9Be_9A@2x.jpeg","Sanjar Suvonov","AN",30))
        listCourse.add(VideoCourse("Android kursi","https://tproger.ru/s3/uploads/2015/03/android-development-770x270.jpg","https://miro.medium.com/fit/c/262/262/1*MjhYbbidoKrR3CNN9Be_9A@2x.jpeg","Sanjar Suvonov","AN",30))
        listCourse.add(VideoCourse("Android kursi","https://tproger.ru/s3/uploads/2015/03/android-development-770x270.jpg","https://miro.medium.com/fit/c/262/262/1*MjhYbbidoKrR3CNN9Be_9A@2x.jpeg","Sanjar Suvonov","AN",30))
        listCourse.add(VideoCourse("Android kursi","https://tproger.ru/s3/uploads/2015/03/android-development-770x270.jpg","https://miro.medium.com/fit/c/262/262/1*MjhYbbidoKrR3CNN9Be_9A@2x.jpeg","Sanjar Suvonov","AN",30))
        listCourse.add(VideoCourse("Android kursi","https://tproger.ru/s3/uploads/2015/03/android-development-770x270.jpg","https://miro.medium.com/fit/c/262/262/1*MjhYbbidoKrR3CNN9Be_9A@2x.jpeg","Sanjar Suvonov","AN",30))
        listCourse.add(VideoCourse("Android kursi","https://tproger.ru/s3/uploads/2015/03/android-development-770x270.jpg","https://miro.medium.com/fit/c/262/262/1*MjhYbbidoKrR3CNN9Be_9A@2x.jpeg","Sanjar Suvonov","AN",30))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VideoCourcesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VideoCourcesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}