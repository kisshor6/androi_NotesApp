package com.example.march10_roomdatabase

import androidx.lifecycle.LiveData

class ContentRepository (private val contentDao: ContentDao) {

    val allContent : LiveData<List<Content>> = contentDao.getAllContent()

    suspend fun insert(content: Content){
        contentDao.insert(content)
    }

    suspend fun delete(content: Content){
        contentDao.delete(content)
    }
}