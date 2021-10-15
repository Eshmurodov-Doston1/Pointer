package com.example.pointer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.R
import com.example.pointer.models.mygroup.History


class StudentHistoryAdapter (var context: Context, var list: ArrayList<History>):
    RecyclerView.Adapter<StudentHistoryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun onBind(history: History, position: Int) {

            itemView.findViewById<TextView>(R.id.lesson_name).text = (position + 1).toString() + ". " + history.lessonName
            itemView.findViewById<TextView>(R.id.lesson_date).text = history.lessonDate

            if(history.coming == true)
            {

                itemView.findViewById<ImageView>(R.id.image).setImageResource(R.drawable.ic_baseline_check_box_24)
            }
            else
            {
                itemView.findViewById<ImageView>(R.id.image).setImageResource(R.drawable.ic_baseline_check_box_outline_blank_24)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_student_history, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }
    override fun getItemCount(): Int = list.size

}
