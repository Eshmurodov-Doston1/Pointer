package com.example.pointer.fragments.mainAdapterFragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.mainAdapter.adapterView.ViewPagerAdapterVideoCourse
import com.example.pointer.adapters.vodeoCourseAdapters.PagerAdapterVideoCourse
import com.example.pointer.databinding.FragmentVideoCourseViewPagerBinding
import com.example.pointer.databinding.ItemTabBinding
import com.example.pointer.databinding.ItemVideosCourseBinding
import com.example.pointer.models.videocources.VideoCourse
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialSharedAxis
import com.squareup.picasso.Picasso
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VideoCourseViewPagerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VideoCourseViewPagerFragment : Fragment(R.layout.fragment_video_course_view_pager) {
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

    private val binding by viewBinding(FragmentVideoCourseViewPagerBinding::bind)
    lateinit var pagerAdapterVideoCourse: ViewPagerAdapterVideoCourse
    lateinit var listCourse:ArrayList<VideoCourse>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loadCourse()


            exitTransition = Hold()
            exitTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
            reenterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)
            cardMy.setOnClickListener {
                val extras = FragmentNavigatorExtras(cardMy to "My_cardView")
                findNavController().navigate(R.id.videoCourcesFragment, null, null, extras)
            }


            pagerAdapterVideoCourse = ViewPagerAdapterVideoCourse()
            Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ56af_9rmSjIvrqSXgrdzJBZJDNfYcWT7jmX5hD11mEQY81ukwx5vxoIEPY_bVp7PPTmU&usqp=CAU").into(imageStudent)
            name.text = "Dostonbek Eshmurodov"
            pagerAdapterVideoCourse.submitList(listCourse)
            viewPager2.adapter = pagerAdapterVideoCourse
            TabLayoutMediator(tabLayout,viewPager2){ tab,position->
                tab.text = listCourse[position].categoryName
            }.attach()
            setTabs()
            viewPager2.clipToPadding=false
            viewPager2.clipChildren=false
            viewPager2.offscreenPageLimit = 2
            viewPager2.setPageTransformer { page, position ->
                var a= 1-Math.abs(position)
                page.scaleY = 0.85F+a*0.1f
            }
            tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val itemTabBinding = tab?.customView?.let { ItemTabBinding.bind(it) }
                    itemTabBinding?.tabCons?.setBackgroundColor(Color.parseColor("#01D8D0"))
                    itemTabBinding?.textTab?.setTextColor(Color.WHITE)
                    //itemTabBinding?.btn?.setColor(Color.WHITE)
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    val itemTabBinding = tab?.customView?.let { ItemTabBinding.bind(it) }
                    itemTabBinding?.tabCons?.setBackgroundColor(Color.WHITE)
                    itemTabBinding?.textTab?.setTextColor(Color.parseColor("#9D9FA0"))
                    //  itemTabBinding?.btn?.setColor(Color.WHITE)
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

            })
            tabLayout.clipChildren = false
            tabLayout.clipToPadding = false
        }
    }
    private fun setTabs() {
        val tabCount = binding.tabLayout.tabCount
        for (i in 0 until tabCount){
            var itemTabBinding = ItemTabBinding.inflate(LayoutInflater.from(requireContext()),null,false)
            val tabAt = binding.tabLayout.getTabAt(i)
            tabAt?.customView = itemTabBinding.root
            itemTabBinding.textTab.text = listCourse[i].categoryName

            if (i==0){
                itemTabBinding.tabCons.setBackgroundColor(Color.parseColor("#01D8D0"))
                itemTabBinding.textTab.setTextColor(Color.WHITE)
                // itemTabBinding.btn.setColor(Color.WHITE)
            }else{
                itemTabBinding?.tabCons?.setBackgroundColor(Color.WHITE)
                itemTabBinding.textTab.setTextColor(Color.parseColor("#9D9FA0"))
                //  itemTabBinding.btn.setColor(Color.WHITE)
            }
        }
    }

    private fun loadCourse() {
        listCourse = ArrayList()
        listCourse.add(VideoCourse("3s 15min","Barchasi","Android kursi","https://thumbs.dreamstime.com/b/web-development-coding-programming-internet-technology-business-concept-web-development-coding-programming-internet-technology-122741764.jpg","https://miro.medium.com/fit/c/262/262/1*MjhYbbidoKrR3CNN9Be_9A@2x.jpeg","Sanjar Suvonov","AN",30))
        listCourse.add(VideoCourse("3s 15min","UI/UX ","Android kursi","https://thumbs.dreamstime.com/b/web-development-coding-programming-internet-technology-business-concept-web-development-coding-programming-internet-technology-122741764.jpg","https://miro.medium.com/fit/c/262/262/1*MjhYbbidoKrR3CNN9Be_9A@2x.jpeg","Sanjar Suvonov","AN",30))
        listCourse.add(VideoCourse("3s 15min","Android","Android kursi","https://thumbs.dreamstime.com/b/web-development-coding-programming-internet-technology-business-concept-web-development-coding-programming-internet-technology-122741764.jpg","https://miro.medium.com/fit/c/262/262/1*MjhYbbidoKrR3CNN9Be_9A@2x.jpeg","Sanjar Suvonov","AN",30))
        listCourse.add(VideoCourse("3s 15min","IOS","Android kursi","https://thumbs.dreamstime.com/b/web-development-coding-programming-internet-technology-business-concept-web-development-coding-programming-internet-technology-122741764.jpg","https://miro.medium.com/fit/c/262/262/1*MjhYbbidoKrR3CNN9Be_9A@2x.jpeg","Sanjar Suvonov","AN",30))
        listCourse.add(VideoCourse("3s 15min","Web","Android kursi","https://thumbs.dreamstime.com/b/web-development-coding-programming-internet-technology-business-concept-web-development-coding-programming-internet-technology-122741764.jpg","https://miro.medium.com/fit/c/262/262/1*MjhYbbidoKrR3CNN9Be_9A@2x.jpeg","Sanjar Suvonov","AN",30))
        listCourse.add(VideoCourse("3s 15min","Backend ","Android kursi","https://thumbs.dreamstime.com/b/web-development-coding-programming-internet-technology-business-concept-web-development-coding-programming-internet-technology-122741764.jpg","https://miro.medium.com/fit/c/262/262/1*MjhYbbidoKrR3CNN9Be_9A@2x.jpeg","Sanjar Suvonov","AN",30))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VideoCourseViewPagerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VideoCourseViewPagerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}