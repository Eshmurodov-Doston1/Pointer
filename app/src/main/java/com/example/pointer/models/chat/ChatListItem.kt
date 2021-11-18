package com.example.pointer.models.chat

import android.graphics.drawable.Drawable

data class ChatListItem(
    val id: String,
    val id2: String,
    val chatName: String,
    val avatar: Drawable,
    var lastMessage: String = "",
    var unreadMessages: Int = 0,
    var lastMessageSent: Long = 0
)