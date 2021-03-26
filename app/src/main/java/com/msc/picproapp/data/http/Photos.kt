package com.msc.picproapp.data.http

import com.google.gson.annotations.SerializedName

data class Photos(
    @SerializedName("id")
    var id: String,
    @SerializedName("urls")
    var urls: Url,
    @SerializedName("user")
    var user: User
)

data class Url(
    @SerializedName("raw")
    var raw: String,
    @SerializedName("full")
    var full: String,
    @SerializedName("regular")
    var regular: String,
    @SerializedName("smal")
    var small: String,
    @SerializedName("thumb")
    var thumb: String
)

data class User(
    @SerializedName("id")
    var id: String,
    @SerializedName("username")
    var username: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("twiter_name")
    var twiter_name: String,
    @SerializedName("location")
    var location: String,
    @SerializedName("instagram_username")
    var instagramUsername: String,
    @SerializedName("profile_image")
    var profileImage: ProfileImage
)

data class ProfileImage(
    @SerializedName("small")
    var small: String,
    @SerializedName("medium")
    var medium: String,
    @SerializedName("large")
    var large: String)

