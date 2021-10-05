package com.example.pointer.adapters

import android.content.Context
import com.example.pointer.extensions.SingleBlock
import com.example.pointer.models.News

class NewsAdapter(var context: Context, var newsList: List<News>) {
    private var listener: SingleBlock<News>? = null

    fun setOnCLickListener(block: SingleBlock<News>) {
        listener = block
    }

}