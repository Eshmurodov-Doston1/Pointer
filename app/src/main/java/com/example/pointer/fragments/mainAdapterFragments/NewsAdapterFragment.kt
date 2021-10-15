package com.example.pointer.fragments.mainAdapterFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.NewsAdapter
import com.example.pointer.adapters.mainAdapter.newsViewAdapter.NewsAdapterPager
import com.example.pointer.databinding.FragmentNewsAdapterBinding
import com.example.pointer.databinding.FragmentNewsBinding
import com.example.pointer.models.News
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsAdapterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsAdapterFragment : Fragment(R.layout.fragment_news_adapter) {
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
    private val binding by viewBinding(FragmentNewsAdapterBinding::bind)
    private lateinit var newsAdapter: NewsAdapterPager
    private lateinit var newsList: ArrayList<News>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            initData()
            newsAdapter = NewsAdapterPager(requireContext(), newsList)
            viewPager.adapter = newsAdapter
        }
    }

    private fun initData() {
        newsList = ArrayList()
        newsList.add(News(R.drawable.click1, "", 11, "", ""))
        newsList.add(News(R.drawable.click1, "", 11, "", ""))
        newsList.add(News(R.drawable.click2, "", 11, "", ""))
        newsList.add(News(R.drawable.click3, "", 11, "", ""))
        newsList.add(News(R.drawable.click4, "", 11, "", ""))
        newsList.add(News(R.drawable.click5, "", 11, "", ""))
        newsList.add(News(R.drawable.click6, "", 11, "", ""))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewsAdapterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsAdapterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}