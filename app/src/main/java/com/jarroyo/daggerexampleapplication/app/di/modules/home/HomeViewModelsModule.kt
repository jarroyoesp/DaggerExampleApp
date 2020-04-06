package com.jarroyo.daggerexampleapplication.app.di.modules.home

import androidx.lifecycle.ViewModel
import com.jarroyo.daggerexampleapplication.ui.viewModels.home.ProfileViewModel
import com.jarroyo.daggerexampleapplication.ui.viewModels.home.post.PostViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import kotlin.reflect.KClass

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
interface HomeViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun bindProfileViewModel(authViewModel: ProfileViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    fun bindPostViewModel(postsViewModel: PostViewModel): ViewModel
}