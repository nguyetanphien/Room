package com.uits.room.Database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RencentMusic")
class RecentHistory {
    @PrimaryKey
    @ColumnInfo(name = "ID")
    var id: String = ""
    @ColumnInfo(name = "Images")
    var images: String = ""
    @ColumnInfo(name = "Title")
    var title: String = ""
    @ColumnInfo(name = "Name")
    var name: String = ""

}