package com.example.mvvm.db

import android.content.Context
import android.os.Environment
import  androidx.room.Database
import androidx.room.Room
import  androidx.room.RoomDatabase

@Database(entities = arrayOf(Subscriber::class),version = 4, exportSchema = false)
abstract class SubscriberDatabase:RoomDatabase() {

    abstract  val subscriberDAO:SubscriberDAO

    companion object{
        @Volatile
        private var INSTANCE:SubscriberDatabase?=null

        fun getInstance(context: Context): SubscriberDatabase? {

                synchronized(SubscriberDatabase::class) {
                    var instance:SubscriberDatabase?=INSTANCE
                    if(instance==null){

                        instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            SubscriberDatabase::class.java,
                            "Subscriber_database.db"
                        ) .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build()
                    }
                    return instance
                }


        }
    }
}