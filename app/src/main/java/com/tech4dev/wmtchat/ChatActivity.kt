package com.tech4dev.wmtchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tech4dev.wmtchat.adapter.ChatsAdapter
import com.tech4dev.wmtchat.model.Chats
import com.tech4dev.wmtchat.model.Message
import java.text.SimpleDateFormat
import java.util.*

class ChatActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var messageRV: RecyclerView
    private lateinit var messageTyped: EditText
    private lateinit var sendButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        //Get username from the Intent which starts the activity
        val username: String = intent.getStringExtra("USER") ?: ""

        val sampleChats = SampleChats()
        //Get chat details of the specified user
        val chat: Chats? = sampleChats.getChatsOf(username)
        //Get the messages of the specified user
        val listOfMessages: MutableList<Message> = chat!!.messages.toMutableList()

        setupToolbar(username)

        setupChatRecyclerview(listOfMessages)

        messageTyped = findViewById(R.id.message)
        sendButton = findViewById(R.id.sendButton)

        sendButton.setOnClickListener{
            //Get user input
            val userInput: String = messageTyped.text.toString() ?: ""
            //Update the listOfMessages above
            val sdf = SimpleDateFormat("h:mm a")
            val time: String = sdf.format(Date())
            ////Create a message type
            val message = Message(
                sender = "me",
                time = time,
                message = userInput,
                receiver = username
            )
            ////Then add to list
            listOfMessages.add(message)

            setupChatRecyclerview(listOfMessages)

            messageTyped.setText("")
        }
    }

    private fun setupChatRecyclerview(listOfMessages: List<Message>) {
        messageRV = findViewById(R.id.messageSection)
        messageRV.layoutManager = LinearLayoutManager(this)
        messageRV.adapter = ChatsAdapter(this, listOfMessages)
    }

    private fun setupToolbar(username: String) {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = username
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}