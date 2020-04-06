package com.jarroyo.daggerexampleapplication.app.di.component

import android.app.Application
import com.jarroyo.daggerexampleapplication.app.di.modules.ActivityBuildersModule
import com.jarroyo.daggerexampleapplication.app.di.modules.AppModule
import com.jarroyo.daggerexampleapplication.app.di.viewModel.ViewModelFactoryModule
import com.jarroyo.daggerexampleapplication.ui.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelFactoryModule::class,
        AndroidInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}