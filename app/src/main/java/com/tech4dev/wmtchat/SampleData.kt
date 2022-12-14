package com.tech4dev.wmtchat

import com.tech4dev.wmtchat.model.*

class SampleCalls{
    val LIST_OF_CALLS: MutableList<CallModel> = mutableListOf(
        CallModel("Jerry Springer", "Sptember 15, 10:19"),
        CallModel("Vivian Okorie", "September 16, 11:20"),
        CallModel("Michael Spence", "September 16, 02:13"),
        CallModel("+234 8125260122", "September 22, 12:05")
    )
}

class SampleStatus{
    val LIST_OF_STATUS: List<Status> = listOf(
        Status("Ann B", "23 minutes ago"),
        Status("Jonah Clement", "10 Minutes ago"),
        Status("Eze Emmanuel", "7 hours ago"),
        Status("John Cham", "10 hours ago")
    )
}

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