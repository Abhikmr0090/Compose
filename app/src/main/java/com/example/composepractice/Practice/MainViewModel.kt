package com.example.composepractice.Practice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composepractice.Users

class MainViewModel : ViewModel() {

    val messagesLiveData = MutableLiveData(listOf<MessageModel>())
    val messages: LiveData<List<MessageModel>>
        get() = messagesLiveData

    val usersLiveData   = MutableLiveData(listOf<Users>())
    val users: LiveData<List<Users>>
        get() = usersLiveData

    fun addMessage(message: MessageModel) {
        messagesLiveData.value = listOf(message)
        Log.d("TAG", "addMessage: ${messagesLiveData.value}")
    }

    fun searchUser(text : String){
        Log.d("TAG", "searchUser: $text")
        users.value?.filter {
            it.userName == text
        }
    }
}