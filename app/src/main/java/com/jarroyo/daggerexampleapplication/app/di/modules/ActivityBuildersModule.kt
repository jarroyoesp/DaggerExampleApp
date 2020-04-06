package com.jarroyo.daggerexampleapplication.app.di.modules

import com.jarroyo.daggerexampleapplication.app.di.modules.auth.AuthModule
import com.jarroyo.daggerexampleapplication.app.di.modules.auth.AuthRepositoryModule
import com.jarroyo.daggerexampleapplication.app.di.modules.auth.AuthScope
import com.jarroyo.daggerexampleapplication.app.di.modules.auth.AuthViewModelsModule
import com.jarroyo.daggerexampleapplication.app.di.modules.home.HomeFragmentBuildersModule
import com.jarroyo.daggerexampleapplication.app.di.modules.home.HomeModule
import com.jarroyo.daggerexampleapplication.app.di.modules.home.HomeScope
import com.jarroyo.daggerexampleapplication.app.di.modules.home.HomeViewModelsModule
import com.jarroyo.daggerexampleapplication.ui.auth.AuthActivity
import com.jarroyo.daggerexampleapplication.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @AuthScope
    @ContributesAndroidInjector(modules = [AuthViewModelsModule::class, AuthModule::class, AuthRepositoryModule::class])
    abstract fun contributeAuthActivity(): AuthActivity


    @HomeScope
    @ContributesAndroidInjector(modules = [HomeFragmentBuildersModule::class, HomeViewModelsModule::class, HomeModule::class])
    abstract fun contributeHomeActivity(): HomeActivity

}