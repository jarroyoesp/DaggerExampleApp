package com.jarroyo.daggerexampleapplication.data.source.network.auth

import com.jarroyo.daggerexampleapplication.domain.base.user.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthAPI {

    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Call<User>
}