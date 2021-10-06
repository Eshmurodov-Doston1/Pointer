package com.example.pointer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.pointer.R
import com.example.pointer.extensions.SingleBlock
import com.example.pointer.models.News

class NewsAdapter(var context: Context, var newsList: List<News>) : PagerAdapter() {
    private var listener: SingleBlock<News>? = null

    fun setOnCLickListener(block: SingleBlock<News>) {
        listener = block
    }

    override fun getCount(): Int = newsList.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_news, container, false)

        val ivImage = view.findViewById<ImageView>(R.id.iv_image)

        ivImage.setImageResource(newsList[position].image)

        view.setOnClickListener {
            listener?.invoke(newsList[position])
        }
        container.addView(view)
        return view
    }

}