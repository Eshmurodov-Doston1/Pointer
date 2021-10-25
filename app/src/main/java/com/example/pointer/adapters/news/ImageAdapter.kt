package com.example.pointer.adapters.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pointer.R
import com.example.pointer.databinding.ItemImageSwipeBinding

class ImageAdapter(private var image: List<Int>) : RecyclerView.Adapter<ImageAdapter.VH>() {

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemImageSwipeBinding.bind(itemView)
        val image = binding.image

        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_image_swipe, parent, false))
    }

    override fun onBindViewHolder(holder: ImageAdapter.VH, position: Int) {
        holder.image.setImageResource(image[position])
    }

    override fun getItemCount(): Int {
        return image.size
    }


}