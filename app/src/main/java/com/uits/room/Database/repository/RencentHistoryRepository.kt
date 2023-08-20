package com.uits.room.Database.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.uits.room.Database.Dao.RecentHistoryDAO
import com.uits.room.Database.Model.RecentHistory


class RencentHistoryRepository(private val recentHistoryDAO: RecentHistoryDAO) {
    val allRecentHistory: LiveData<List<RecentHistory>> = recentHistoryDAO.getRecentHistory()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(recentHistory: com.uits.room.Database.Entities.RecentHistory) {
        recentHistoryDAO.insert(recentHistory)
    }
}