package com.example.pointer.models

import android.graphics.drawable.Drawable

data class ChatListItem(
    val chatName: String,
    val avatar: Drawable,
    val lastMessage: String,
    val unreadMessages: Int,
    val lastMessageSent: Long
)