package com.jarroyo.daggerexampleapplication.domain.base.post

data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)