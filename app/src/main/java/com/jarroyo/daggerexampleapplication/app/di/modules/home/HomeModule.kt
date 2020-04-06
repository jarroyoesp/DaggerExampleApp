package com.jarroyo.daggerexampleapplication.app.di.modules.home

import com.jarroyo.daggerexampleapplication.data.source.network.home.HomeAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class HomeModule {
    @HomeScope
    @Provides
    fun provideHomeAPI(retrofit: Retrofit): HomeAPI {
        return retrofit.create(HomeAPI::class.java)
    }
}