package com.jarroyo.daggerexampleapplication.data.source.network.home

import com.jarroyo.daggerexampleapplication.domain.base.post.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeAPI {

    @GET("posts?userId={id}")
    fun getPosts(@Query("userId") id: Int): Call<List<Post>>
}