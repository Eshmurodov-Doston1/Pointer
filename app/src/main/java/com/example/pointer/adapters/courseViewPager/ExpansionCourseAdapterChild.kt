package com.example.pointer.adapters.courseViewPager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.databinding.ChildItemBinding
import com.example.pointer.databinding.ItemRvBinding
import com.example.pointer.models.student.Course

class ExpansionCourseAdapterChild(var onChildClick: ExpansionCourseAdapter.OnChildClick):ListAdapter<String,ExpansionCourseAdapterChild.Vh>(MyDiffUtil()) {
    inner class Vh(var childItemBinding: ChildItemBinding):RecyclerView.ViewHolder(childItemBinding.root){
        fun onBind(str:String,position: Int){
            childItemBinding.text.text = str
            itemView.setOnClickListener {
                onChildClick.onChildClick(str,childItemBinding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ChildItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position),position)
    }

    class MyDiffUtil:DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.equals(newItem)
        }

    }
}