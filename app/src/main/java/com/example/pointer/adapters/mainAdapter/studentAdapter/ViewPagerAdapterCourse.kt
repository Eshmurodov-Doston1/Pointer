package com.example.pointer.adapters.mainAdapter.studentAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.databinding.ItemCourseStudentAdapterBinding
import com.example.pointer.models.student.StudentCourse
import com.squareup.picasso.Picasso

class ViewPagerAdapterCourse(var context: Context):ListAdapter<StudentCourse,ViewPagerAdapterCourse.Vh>(MyDiffUtill()) {
    inner class Vh(var itemCourceStudentBinding: ItemCourseStudentAdapterBinding) : RecyclerView.ViewHolder(itemCourceStudentBinding.root) {
        fun onBind(studentCourse: StudentCourse, position: Int) {
            Picasso.get().load(studentCourse.image).into(itemCourceStudentBinding.image)
            Picasso.get().load(studentCourse.teacherImage).into(itemCourceStudentBinding.imageTeacher)
            itemCourceStudentBinding.nameCourse.text = studentCourse.name
            itemCourceStudentBinding.countCourse.text = "${studentCourse.videoCourseNumber} ta dars"
            itemCourceStudentBinding.nameCourseSi.text = studentCourse.shortNameCourse
            itemCourceStudentBinding.teacherName.text = studentCourse.teacherName
            itemCourceStudentBinding.fullName.text = studentCourse.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemCourseStudentAdapterBinding.inflate(
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
}