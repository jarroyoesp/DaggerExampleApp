package com.jarroyo.daggerexampleapplication.data.repository.user

import android.content.Context
import com.jarroyo.daggerexampleapplication.data.source.network.auth.AuthAPI
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import retrofit2.await


class UserRepository(
        private val context: Context,
        private val authAPI: AuthAPI
) {


    /***********************************************************************************************
     * GET ACCOUNT
     **********************************************************************************************/
    suspend fun getAccount() = flow {
        val user = authAPI.getUser(1).await()
        var pos = 0
        while (pos < 100 ) {
            emit(user)
            delay(1000)
            pos ++
        }
    }
}