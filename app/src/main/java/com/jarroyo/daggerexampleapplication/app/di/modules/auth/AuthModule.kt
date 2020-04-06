package com.jarroyo.daggerexampleapplication.app.di.modules.auth

import com.jarroyo.daggerexampleapplication.data.source.network.auth.AuthAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule {

    @AuthScope
    @Provides
    fun provideAuthAPI(retrofit: Retrofit): AuthAPI {
        return retrofit.create(AuthAPI::class.java)
    }
}