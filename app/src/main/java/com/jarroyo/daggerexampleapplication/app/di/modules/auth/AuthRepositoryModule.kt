package com.jarroyo.daggerexampleapplication.app.di.modules.auth

import android.app.Application
import com.jarroyo.daggerexampleapplication.data.repository.user.UserRepository
import com.jarroyo.daggerexampleapplication.data.source.network.auth.AuthAPI
import dagger.Module
import dagger.Provides

@Module()
class AuthRepositoryModule {

    @AuthScope
    @Provides
    fun provideUserRepository(app: Application, authAPI: AuthAPI) = UserRepository(app, authAPI)
}