package com.tech4dev.wmtchat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tech4dev.wmtchat.R
import com.tech4dev.wmtchat.SampleCalls
import com.tech4dev.wmtchat.model.CallModel

class CallsAdapter(val context: Context): RecyclerView.Adapter<CallsAdapter.CallViewHolder>() {
    val listOfCalls: MutableList<CallModel> = SampleCalls().LIST_OF_CALLS

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder {
        val itemView: View = LayoutInflater.from(context).inflate(R.layout.call_layout, parent, false)

        return CallViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        holder.username.text = listOfCalls[position].name
        holder.time.text = listOfCalls[position].date
    }

    override fun getItemCount(): Int = listOfCalls.size

    class CallViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val username: TextView = itemView.findViewById(R.id.username)
        val time: TextView = itemView.findViewById(R.id.time)
    }
}