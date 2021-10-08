package com.example.pointer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.R
import com.example.pointer.models.Table


class TableRecyclerAdapter(var context: Context, var list: ArrayList<Table>): RecyclerView.Adapter<TableRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var startTime = itemView.findViewById<TextView>(R.id.start_lesson)
        val endTime = itemView.findViewById<TextView>(R.id.end_lesson)
        val group = itemView.findViewById<TextView>(R.id.group)
        val course = itemView.findViewById<TextView>(R.id.course)
        val roomNumber = itemView.findViewById<TextView>(R.id.room_number)
        val imageStudent = itemView.findViewById<ImageView>(R.id.image_student)
        val name = itemView.findViewById<TextView>(R.id.student_name)

        fun onBind(table: Table)
        {
            itemView.apply {
                startTime.text = table.startLesson
                endTime.text = table.endLesson
                group.text = table.group
                course.text = table.course
                roomNumber.text = table.room
                table.image?.let { imageStudent.setImageResource(it) }
                name.text = table.name
            }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size
}

