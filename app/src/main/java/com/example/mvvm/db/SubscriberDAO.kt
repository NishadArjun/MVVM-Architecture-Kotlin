package com.example.mvvm.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {

    @Insert
    suspend fun  insertSubscriber(subscriber: Subscriber):Long

    @Update
    suspend fun  updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun  deleteSubscriber(subscriber: Subscriber)

    @Query(value = "DELETE from Subscriber_data_table")
    suspend fun deleteAll()


    @Query(value = "select * from Subscriber_data_table")
     fun getAllSubscribers():LiveData<List<Subscriber>>

}