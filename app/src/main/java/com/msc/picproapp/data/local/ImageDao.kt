package com.msc.picproapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.msc.picproapp.data.entity.Image

@Dao
interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(image: Image)

    @Query("Delete FROM img_table")
    suspend fun delete(favoriteImage: Image)

    @Query("SELECT * FROM img_table")
    suspend fun getFavoriteImages(): List<Image>

}