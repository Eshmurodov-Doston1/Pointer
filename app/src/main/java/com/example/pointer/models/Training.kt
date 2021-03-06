package com.example.pointer.models

import java.io.Serializable

data class Training (var image: Int? = null,
                     var trainingName: String? = null,
                     var time: String? = null,
                     var address: String? = null,
                     var speakerImage: Int? = null,
                     var speakerName: String? = null,
                     var type: String? = null,
                     var videoUrl: String? = null,
                     var countMember: String? = null): Serializable