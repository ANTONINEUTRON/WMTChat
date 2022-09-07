package com.tech4dev.wmtchat

import com.tech4dev.wmtchat.model.Chats
import com.tech4dev.wmtchat.model.Message
import com.tech4dev.wmtchat.model.User

class SampleData {
    val LIST_OF_FRIENDS: List<User> = listOf(
        User("James Paul", "Hi i am alive"),
        User("Joan Okereke", "Hey i am using whatsapp"),
        User("Miracle Ebere", "Programming vibes"),
        User("Fadwa Fuad", "I love coding"),
        User("Ruth Okeniyi", "Hey i am using whatsapp"),
    )
}

class SampleMessages{
    val LIST_OF_MESSAGES: List<Message> = listOf(
        Message("Joan Okereke", "19:00", "I need to get my book", "me"),
        Message("Emelda Joe", "07:00", "Hello, hope you are okay", "me"),
        Message("Mr. Atimi", "09:00", "There will be class", "me"),
        Message("Job Man", "17:00", "Come for the interview","me")
    )
}

class SampleChats{
    val LIST_OF_CHATS: List<Chats> = listOf(
        Chats("Joan Okereke", listOf(
            Message("me", "19:00", "I am coming over", "Joan Okereke"),
            Message("Joan Okereke", "19:00", "I need to get my book", "me")
        )),
        Chats("Emelda Joe", listOf(
            Message("Emelda Joe", "07:00", "Hello, hope you are okay", "me")
        )),
        Chats("Mr. Atimi", listOf(
            Message("Mr. Atimi", "09:00", "There will be class", "me")
        )),
        Chats("Job Man", listOf(
            Message("Job Man", "17:00", "Come for the interview","me")
        ))
    )

    fun getChatsOf(username: String): Chats?{
        for(item in LIST_OF_CHATS){
            if(item.sender == username){
                return item;
            }
        }

        return null
    }
}