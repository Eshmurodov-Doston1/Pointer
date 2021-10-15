package com.example.pointer.adapters.mainAdapter.newsViewAdapter

import android.content.Context
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.FragmentNavigator
import androidx.viewpager.widget.PagerAdapter
import com.example.pointer.R
import com.example.pointer.extensions.SingleBlock
import com.example.pointer.models.News

class NewsAdapterPager(
    var context: Context,
    var newsList: List<News>
) : PagerAdapter() {
    private var listener: SingleBlock<News>? = null
    private var previousTime = SystemClock.elapsedRealtime()

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
//        view.setOnClickListener {
//            listener?.invoke(newsList[position])
//            val extras: FragmentNavigator.Extras = FragmentNavigator.Extras.Builder()
//                .addSharedElement(ivImage, "my_image").build()
//            ivImage.transitionName = "my_iamge"
//        }
        container.addView(view)
        return view
    }
}