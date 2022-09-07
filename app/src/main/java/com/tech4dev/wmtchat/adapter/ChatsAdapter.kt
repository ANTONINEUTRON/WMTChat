package com.tech4dev.wmtchat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tech4dev.wmtchat.R
import com.tech4dev.wmtchat.SampleChats
import com.tech4dev.wmtchat.SampleMessages
import com.tech4dev.wmtchat.model.Chats
import com.tech4dev.wmtchat.model.Message

class ChatsAdapter(val context: Context, val userName: String): RecyclerView.Adapter<ChatsAdapter.ChatsViewHolder>() {
    val sampleChats = SampleChats()
    val chat: Chats? = sampleChats.getChatsOf(userName)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {
        val itemView: View = LayoutInflater.from(context).inflate(R.layout.chats_layout, parent, false)

        return ChatsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return chat?.messages?.size ?: 0
    }

    class ChatsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //TODO
    }
}