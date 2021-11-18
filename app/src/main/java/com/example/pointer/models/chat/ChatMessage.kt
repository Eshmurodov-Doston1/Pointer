package com.example.pointer.models.chat

class ChatMessage(
    var id: String = "",
    var messageText: String = "",
    var sentTime: Long = 0,
    var isSender: Boolean = true
)