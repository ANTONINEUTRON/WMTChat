package com.tech4dev.wmtchat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.tech4dev.wmtchat.R
import com.tech4dev.wmtchat.SampleChats
import com.tech4dev.wmtchat.SampleMessages
import com.tech4dev.wmtchat.model.Chats
import com.tech4dev.wmtchat.model.Message

class ChatsAdapter(val context: Context, val listOfMessages: List<Message>): RecyclerView.Adapter<ChatsAdapter.ChatsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {
        val itemView: View = LayoutInflater.from(context).inflate(R.layout.chats_layout, parent, false)

        return ChatsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {
        val message: Message = listOfMessages[position]

        //Identify what type of message it is and show at the appropriete position
        if(message.sender == "me"){
            holder.messageSent.text = message.message
            holder.msgSentTime.text = message.time

            holder.leftSection.visibility = View.GONE
        }else{
            holder.senderMessage.text = message.message
            holder.sendTime.text = message.time

            holder.rightSection.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return listOfMessages.size
    }

    class ChatsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val senderMessage: TextView = itemView.findViewById(R.id.senderMessage)
        val sendTime: TextView = itemView.findViewById(R.id.sendTime)
        val messageSent: TextView = itemView.findViewById(R.id.messageSent)
        val msgSentTime: TextView = itemView.findViewById(R.id.messageSentTime)

        val leftSection: CardView = itemView.findViewById(R.id.senderSection)
        val rightSection: CardView = itemView.findViewById(R.id.userSection)
    }
}