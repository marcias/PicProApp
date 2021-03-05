package com.msc.picproapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search-img-table")
data class Search(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "search-key") val searchKey: String,
    @ColumnInfo(name = "saved") val saved: Boolean,
    @ColumnInfo(name = "datestamp") val datestamp: String
)