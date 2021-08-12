package com.example.mvvm.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Subscriber_data_table")
data class Subscriber(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="Subscriber_name")
    val id:Int,

    @ColumnInfo(name="Subscriber_id")
    val name:String,

    @ColumnInfo(name="Subscriber_email")
    val email:String

)