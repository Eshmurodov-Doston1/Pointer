package com.example.pointer.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    var image: Int,
    var date: String,
    var views: Int,
    var title: String,
    var description: String
) : Parcelable