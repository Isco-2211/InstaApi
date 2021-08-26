package com.example.instagramapi.model

data class Data(
    val biography: String,
    val business: Business,
    val facebook_page: Any,
    val figures: Figures,
    val full_name: String,
    val has_channel: Boolean,
    val id: Long,
    val is_business: Boolean,
    val is_joined_recently: Boolean,
    val is_private: Boolean,
    val is_verified: Boolean,
    val profile_picture: ProfilePicture,
    val reel: Reel,
    val username: String,
    val website: Any
)