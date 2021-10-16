package com.example.pointer.adapters.mainAdapter.paymiAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.databinding.ItemPaymeAdapterBinding
import com.example.pointer.models.Payme

class PaymiAdapter:ListAdapter<Payme,PaymiAdapter.Vh>(MyDiffUtill()) {
    inner class Vh(var itemPaymeAdapterBinding: ItemPaymeAdapterBinding):RecyclerView.ViewHolder(itemPaymeAdapterBinding.root){
        fun onBind(payme: Payme,position: Int){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemPaymeAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position),position)
    }
    class MyDiffUtill:DiffUtil.ItemCallback<Payme>(){
        override fun areItemsTheSame(oldItem: Payme, newItem: Payme): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: Payme, newItem: Payme): Boolean {
            return oldItem.equals(newItem)
        }

    }
}