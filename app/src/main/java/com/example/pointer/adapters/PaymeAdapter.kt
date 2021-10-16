package com.example.pointer.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.R
import com.example.pointer.databinding.PaymeItemBinding
import com.example.pointer.models.Payme


class PaymeAdapter(var context: Context, var list: ArrayList<Payme>): RecyclerView.Adapter<PaymeAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: PaymeItemBinding): RecyclerView.ViewHolder(binding.root)
    {

        fun onBind(payme: Payme)
        {
            binding.money.text = payme.money
            binding.tushum.text = payme.title
            payme.type?.let { binding.type.setImageResource(it) }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PaymeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }
    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])

    }
    override fun getItemCount() = list.size
}

