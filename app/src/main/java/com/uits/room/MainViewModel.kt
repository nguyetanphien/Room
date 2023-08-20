package com.uits.room

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.viewModelFactory
import com.uits.room.Database.AppDatabase

import com.uits.room.Database.Model.RecentHistory
import com.uits.room.Database.repository.RencentHistoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainViewModel (context: Application): AndroidViewModel(context) {
    private val recentHistoryRespository: RencentHistoryRepository
    val allRecentHistorys: LiveData<List<RecentHistory>>

    init {
        val recentHistoryDAO = AppDatabase.getDatabase(context).mRecentHistoryDao
        recentHistoryRespository = RencentHistoryRepository(recentHistoryDAO)
        allRecentHistorys = recentHistoryRespository.allRecentHistory

    }

    fun insert(recentHistory: com.uits.room.Database.Entities.RecentHistory) =
        MainScope().launch(Dispatchers.IO) {
            recentHistoryRespository.insert(recentHistory)
        }
}