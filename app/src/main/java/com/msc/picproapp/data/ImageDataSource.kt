package com.msc.picproapp.data

import com.msc.picproapp.data.entity.Image

interface ImageDataSource {

    fun getImage(id: String): String
    fun getAllImages(): List<Image>
    fun saveImage(image: Image)
    fun deleteImage(id: String): String
}