package com.example.pointer.adapters.mainAdapter.traning

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.databinding.ItemTrainingPagerBinding
import com.example.pointer.models.Training

class RvTraning(var list: List<Training>):RecyclerView.Adapter<RvTraning.Vh>() {
    inner class Vh(var itemTraningPagerBinding:ItemTrainingPagerBinding):RecyclerView.ViewHolder(itemTraningPagerBinding.root){
        fun onBind(training: Training,position: Int){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemTrainingPagerBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}