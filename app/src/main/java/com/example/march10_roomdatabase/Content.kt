package com.example.march10_roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "content_table")
class Content (

    @ColumnInfo(name = "title")
    val title : String
){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}