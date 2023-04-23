package com.example.march10_roomdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContentViewModel(application: Application) : AndroidViewModel(application){

    val allContent : LiveData<List<Content>>
    var repository : ContentRepository

    init {
        val db = ContentDatabase.getDatabase(application).getNoteDao()
        repository = ContentRepository(db)
        allContent = repository.allContent
    }

    fun deleteContent(content: Content) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(content)
    }

    fun insertContent(content: Content) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(content)
    }
}