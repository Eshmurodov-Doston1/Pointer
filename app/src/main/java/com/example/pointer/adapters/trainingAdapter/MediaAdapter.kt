package com.example.pointer.adapters.trainingAdapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pointer.R
import com.example.pointer.models.medislider.MediaItem

class MediaAdapter(var list: ArrayList<MediaItem>, var mgr: FragmentManager) :
    FragmentPagerAdapter(mgr, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount() = list.size

    override fun getItem(position: Int): Fragment {
        return if (list[position].image==null) {
            VideoFrag()
        }else{
            ImageFrag()
        }
    }
}

class ImageFrag: Fragment(R.layout.layout_content_image) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_content_image, container, false)
    }
}

class VideoFrag: Fragment(R.layout.layout_content_video) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_content_video, container, false)
    }
}