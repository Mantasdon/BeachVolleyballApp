package com.example.naujasprojektas.db
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PlayerDao {
    @Insert
    suspend fun insertPlayer(player: Player)
    @Update
    suspend fun updatePlayer(player: Player)
    @Delete
    suspend fun deletePlayer(player: Player)

    @Query("SELECT * FROM players_data_table")
    fun getAllPlayers():LiveData<List<Player>>
}