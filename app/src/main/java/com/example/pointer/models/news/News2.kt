package com.example.pointer.models.news

import java.io.Serializable

data class News2(
    var image: List<Int>,
    var news: News
): Serializable