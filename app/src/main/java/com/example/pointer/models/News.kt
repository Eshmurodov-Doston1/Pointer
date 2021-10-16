package com.example.pointer.models
import java.io.Serializable

data class News(
    var image: Int,
    var date: String,
    var views: Int,
    var title: String,
    var description: String
) : Serializable