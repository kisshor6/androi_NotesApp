package com.example.march10_roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Content::class], version = 1, exportSchema = false)
abstract class ContentDatabase : RoomDatabase() {

    abstract fun getNoteDao() : ContentDao

    companion object{

        @Volatile
        private var INSTANCE : ContentDatabase? = null

        fun getDatabase(context : Context) : ContentDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContentDatabase::class.java,
                    "content_DB"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}