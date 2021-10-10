package com.example.pointer.adapters

import android.app.ActivityOptions
import android.content.Context
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.viewpager.widget.PagerAdapter
import com.example.pointer.MainActivity
import com.example.pointer.R
import com.example.pointer.extensions.SingleBlock
import com.example.pointer.fragments.FullNewsFragment
import com.example.pointer.models.News
import com.skydoves.transformationlayout.TransformationLayout

class NewsAdapter(
    private val delegate: PosterDelegate,
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
        val itemPosterTransformationLayout =
            view.findViewById<TransformationLayout>(R.id.item_poster_transformationLayout)
        itemPosterTransformationLayout.transitionName = newsList[position].title
        ivImage.setImageResource(newsList[position].image)
        view.setOnClickListener {
            listener?.invoke(newsList[position])
            val now = SystemClock.elapsedRealtime()
            if (now - previousTime >= itemPosterTransformationLayout.duration) {
                delegate.onItemClick(newsList[position], itemPosterTransformationLayout)
                previousTime = now
            }
//            val optionsCompat =
//                FullNewsFragment().activity?.let { it1 ->
//                    ActivityOptionsCompat.makeSceneTransitionAnimation(
//                        it1,ivImage,"avatar")
//
//                }

        }
        container.addView(view)
        return view
    }

    interface PosterDelegate {
        fun onItemClick(news: News, itemView: TransformationLayout)
    }

}