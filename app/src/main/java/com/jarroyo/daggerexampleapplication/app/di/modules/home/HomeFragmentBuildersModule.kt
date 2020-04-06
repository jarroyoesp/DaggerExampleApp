package com.jarroyo.daggerexampleapplication.app.di.modules.home

import com.jarroyo.daggerexampleapplication.ui.home.fragment.HomeFragment
import com.jarroyo.daggerexampleapplication.ui.home.fragment.PostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

//@Module
//interface ActivityBuildersModule {
//
//    @ContributesAndroidInjector(modules = [AuthViewModelsModule::class])
//    fun contributeMainActivity(): MainActivity
//}

@Module
abstract class HomeFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributePostFragment(): PostFragment
}