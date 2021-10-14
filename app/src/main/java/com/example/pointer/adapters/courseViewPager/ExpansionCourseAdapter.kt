package com.example.pointer.adapters.courseViewPager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.databinding.ChildItemBinding
import com.example.pointer.databinding.ItemRvBinding
import com.example.pointer.models.student.Course
import com.github.florent37.expansionpanel.ExpansionLayout

class ExpansionCourseAdapter(
    var onItemClickListener: OnItemClickListener,
    var onChildClick: OnChildClick):ListAdapter<Course,ExpansionCourseAdapter.Vh>(MyDiffUtil()) {
    lateinit var exPansionCourseAdapterChild:ExpansionCourseAdapterChild
    inner class Vh(var itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(course: Course,position: Int){
            itemRvBinding.name.text = course.courseName

            exPansionCourseAdapterChild = ExpansionCourseAdapterChild(onChildClick)

            exPansionCourseAdapterChild.submitList(course.childCourseList)
            itemRvBinding.rcItem.adapter = exPansionCourseAdapterChild
            itemRvBinding.rcItem.isNestedScrollingEnabled =false

            itemRvBinding.expansionLayout.addListener(object:ExpansionLayout.Listener{
                override fun onExpansionChanged(
                    expansionLayout: ExpansionLayout?,
                    expanded: Boolean
                ) {
                    onItemClickListener.onItemExpansionClick(course,position,expanded,itemRvBinding)
                }

            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position),position)
    }

    class MyDiffUtil:DiffUtil.ItemCallback<Course>(){
        override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem.equals(newItem)
        }
    }
    interface OnItemClickListener{
        fun onItemExpansionClick(course: Course,position: Int,bool:Boolean,itemRvBinding: ItemRvBinding)
    }
    interface OnChildClick{
        fun onChildClick(str:String,itemChildBinding:ChildItemBinding)
    }
}