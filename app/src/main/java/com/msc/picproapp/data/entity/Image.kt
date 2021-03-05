package com.msc.picproapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "img_table")
data class Image(
    @ColumnInfo @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "img-src-id") val imgSrcId: String,
    @ColumnInfo(name = "thumb") val thumb: String,
    @ColumnInfo(name = "full-img") val fullImg: String,
    @ColumnInfo(name = "regular-img") val regularImg: String,
    @ColumnInfo(name = "isFav") val isFac: Boolean
)