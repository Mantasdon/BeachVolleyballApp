package com.example.naujasprojektas

import androidx.compose.runtime.internal.illegalDecoyCallException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.naujasprojektas.db.PlayerDao

class PlayerViewModelFactory (
    private val dao: PlayerDao
):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlayerViewModel::class.java)) {
            return PlayerViewModel(dao) as T
        }
        throw illegalDecoyCallException("Uknown View Model CLass")
    }
}

