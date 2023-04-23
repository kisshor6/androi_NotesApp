package com.example.march10_roomdatabase

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(content: Content)

    @Delete
    suspend fun delete(content: Content)

    @Query("SELECT * FROM content_table ORDER BY id ASC")
    fun getAllContent() : LiveData<List<Content>>
}