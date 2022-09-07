package com.tech4dev.wmtchat.model

data class Message(
    val sender: String,
    val time: String,
    val message: String,
    val receiver: String
)
