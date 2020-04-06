package com.jarroyo.daggerexampleapplication.app.di.modules

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.jarroyo.daggerexampleapplication.R
import com.jarroyo.daggerexampleapplication.util.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module()
class AppModule {

    @Provides
    fun providesString(): String {
        return "Hola que hace"
    }


    /***
     * GLIDE
     */
    @Provides
    fun providesRequestsOptions(): RequestOptions {
        return RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
    }

    @Provides
    fun providesGlideInstance(application: Application, requestOptions: RequestOptions): RequestManager {
        return Glide.with(application).setDefaultRequestOptions(requestOptions)
    }

    /***
     * RETROFIT
     */
    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}