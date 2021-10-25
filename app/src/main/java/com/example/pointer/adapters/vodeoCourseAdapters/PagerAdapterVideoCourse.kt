package com.example.pointer.adapters.vodeoCourseAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.databinding.ItemVideosCourseBinding
import com.example.pointer.models.student.Course
import com.example.pointer.models.videocources.VideoCourse
import com.squareup.picasso.Picasso

class PagerAdapterVideoCourse(var onItemClickListener: OnItemClickListener):ListAdapter<VideoCourse,PagerAdapterVideoCourse.Vh>(MyDiffUtill()) {
    inner class Vh(var itemVideosCourseBinding: ItemVideosCourseBinding):RecyclerView.ViewHolder(itemVideosCourseBinding.root){

        fun onBind(videoCourse: VideoCourse,position: Int){
            itemVideosCourseBinding.apply {
                nameCourse.text = videoCourse.name
               // videoTime.text = videoCourse.vidoTime
                countCourse.text = "${videoCourse.videoCourseNumber} ta dars"
                nameCourseSi.text = videoCourse.shortNameCourse
                freeText.text = "Tekin"
                Picasso.get().load(videoCourse.image).into(image)
                Picasso.get().load(videoCourse.teacherImage).into(imageTeacher)
                teacherName.text = videoCourse.teacherName
                fullName.text = videoCourse.name
                myCard.setOnClickListener {
                    onItemClickListener.onItemClick(videoCourse,position,itemVideosCourseBinding)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemVideosCourseBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position),position)
    }

    class MyDiffUtill:DiffUtil.ItemCallback<VideoCourse    >(){
        override fun areItemsTheSame(oldItem: VideoCourse, newItem: VideoCourse): Boolean {
            return oldItem.equals(newItem)
        }
        override fun areContentsTheSame(oldItem: VideoCourse, newItem: VideoCourse): Boolean {
            return oldItem.equals(newItem)
        }
    }
    interface OnItemClickListener{
        fun onItemClick(videoCourse: VideoCourse,position: Int,itemVideosCourseBinding: ItemVideosCourseBinding)
    }
}