package com.example.pointer.adapters.courseViewPager

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pointer.R
import com.example.pointer.databinding.ItemCourseStudentBinding
import com.example.pointer.models.student.StudentCourse
import com.squareup.picasso.Picasso

class CourseViewPagerAdapter(var context: Context,var onItemClickListener: OnItemClickListener):ListAdapter<StudentCourse,CourseViewPagerAdapter.Vh>(MyDiffUtill()) {
    inner class Vh(var itemCourceStudentBinding: ItemCourseStudentBinding) :
        RecyclerView.ViewHolder(itemCourceStudentBinding.root) {
        fun onBind(studentCourse: StudentCourse, position: Int) {
            Picasso.get().load(studentCourse.image).into(itemCourceStudentBinding.image)
            Picasso.get().load(studentCourse.teacherImage).into(itemCourceStudentBinding.imageTeacher)
            itemCourceStudentBinding.nameCourse.text = studentCourse.name
            itemCourceStudentBinding.countCourse.text = "${studentCourse.videoCourseNumber} ta dars"
            itemCourceStudentBinding.nameCourseSi.text = studentCourse.shortNameCourse
            itemCourceStudentBinding.teacherName.text = studentCourse.teacherName
            itemCourceStudentBinding.fullName.text = studentCourse.name

            itemView.setOnClickListener {
                onItemClickListener.onItemClick(studentCourse,position,itemCourceStudentBinding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemCourseStudentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position), position)
    }

    class MyDiffUtill : DiffUtil.ItemCallback<StudentCourse>() {
        override fun areItemsTheSame(oldItem: StudentCourse, newItem: StudentCourse): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: StudentCourse, newItem: StudentCourse): Boolean {
            return oldItem.equals(newItem)
        }
    }
    interface OnItemClickListener{
        fun onItemClick(studentCourse: StudentCourse,position: Int,itemCourceStudentBinding: ItemCourseStudentBinding)
    }
}