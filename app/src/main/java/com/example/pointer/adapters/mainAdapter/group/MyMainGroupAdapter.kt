package com.example.pointer.adapters.mainAdapter.group

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.R
import com.example.pointer.models.Training
import com.example.pointer.models.mygroup.MyGroup


class MyMainGroupAdapter (var context: Context, var list: ArrayList<MyGroup>,
                          val onClick: (training: MyGroup) -> Unit):
    RecyclerView.Adapter<MyMainGroupAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun onBind(myGroup: MyGroup, position: Int) {

            itemView.findViewById<TextView>(R.id.name).text = myGroup.studentName
            itemView.findViewById<TextView>(R.id.coming).text = myGroup.coming.toString()
            myGroup.image?.let { itemView.findViewById<ImageView>(R.id.image).setImageResource(it) }


            if(myGroup.coming == true)
            {
                itemView.findViewById<TextView>(R.id.coming).text = "Hozir darsda"
            }
            else
            {
                itemView.findViewById<TextView>(R.id.coming).text = "Darsda yo'q"
            }
            if (position == 0)
            {
                itemView.setOnClickListener()
                {
                    onClick(myGroup)
                }
            }
            else
            {
                itemView.setOnClickListener()
                {
                    Toast.makeText(context, myGroup.studentName, Toast.LENGTH_SHORT).show()
                }
            }

        }
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_student1, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }
    override fun getItemCount(): Int = list.size

}
