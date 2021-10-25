package com.example.pointer.adapters.trainingAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.R
import com.example.pointer.models.Training

class NowTrainingRecyclerAdapter(
    var onButtonClick: OnButtonClick, var context: Context,
    var list: ArrayList<Training>, val onClick: (training: Training) -> Unit): RecyclerView.Adapter<NowTrainingRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun onBind(training: Training, position: Int) {
            itemView.apply {
                training.image?.let {
                    itemView.findViewById<ImageView>(R.id.image).setImageResource(
                        it
                    )
                }
                itemView.apply {

                    itemView.findViewById<TextView>(R.id.nameSpeaker).text = training.speakerName
                    itemView.findViewById<TextView>(R.id.nameTraining).text = training.trainingName
                    itemView.findViewById<TextView>(R.id.time).text = training.time
                    itemView.findViewById<TextView>(R.id.address).text = training.address
                    itemView.findViewById<TextView>(R.id.type).text = training.type
                    itemView.findViewById<ConstraintLayout>(R.id.enter).setOnClickListener {
                        onButtonClick.onTraningClick(training,position)
                    }

                }
                itemView.setOnClickListener()
                {
                    onClick(training)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_training_now, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface OnButtonClick{
        fun onTraningClick(training: Training,position: Int)
    }
}