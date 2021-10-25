package com.example.pointer.adapters.pointerCources

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.databinding.ItemCourseAdapterBinding
import com.example.pointer.models.videocources.Programming
import com.squareup.picasso.Picasso

class PointerCourcesAdapter(var onCourseClick: OnCourseClick):ListAdapter<Programming,PointerCourcesAdapter.Vh>(MyDiffUtill()) {
    inner class Vh(var itemCourseAdapterBinding: ItemCourseAdapterBinding):RecyclerView.ViewHolder(itemCourseAdapterBinding.root){
        fun onBind(programming: Programming,position:Int){
          Picasso.get().load(programming.image).into(itemCourseAdapterBinding.imageMy)
            itemCourseAdapterBinding.nameLanguage.text = programming.name
            itemCourseAdapterBinding.continuity.text = programming.course_continuity
            itemCourseAdapterBinding.cons.setOnClickListener {
                onCourseClick.onCourseClic(programming,position,itemCourseAdapterBinding)
            }
        }
    }

    class MyDiffUtill:DiffUtil.ItemCallback<Programming>(){
        override fun areItemsTheSame(oldItem: Programming, newItem: Programming): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: Programming, newItem: Programming): Boolean {
            return oldItem.equals(newItem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemCourseAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
       holder.onBind(getItem(position),position)
    }
    interface OnCourseClick{
        fun onCourseClic(programming: Programming,position: Int,itemCourseAdapterBinding: ItemCourseAdapterBinding)
    }
}