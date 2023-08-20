package com.uits.room.Database.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.uits.room.Database.Entities.RecentHistory

@Dao
interface RecentHistoryDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg recentHistory: RecentHistory)
    @Update
    fun update(vararg  recentHistory: RecentHistory?)
    @Delete
    fun delete(vararg  recentHistory: RecentHistory)
    @Query("SELECT * FROM RencentMusic")
    fun getRecentHistory(): LiveData<List<com.uits.room.Database.Model.RecentHistory>>
}