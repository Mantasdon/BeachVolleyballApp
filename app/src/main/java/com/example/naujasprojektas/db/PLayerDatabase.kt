package com.example.naujasprojektas.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Player::class], version = 1, exportSchema = false)
abstract class PLayerDatabase :RoomDatabase(){
    abstract fun playerDao():PlayerDao
    companion object{
    @Volatile
        private var INSTANCE:PLayerDatabase? = null
        fun getInstance(context: Context):PLayerDatabase{
        synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PLayerDatabase::class.java,
                        "player_data_database"
                    ).build()
                }
            return instance
            }

        }
    }
}