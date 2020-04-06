package com.jarroyo.daggerexampleapplication.ui.viewModels.home

import com.jarroyo.daggerexampleapplication.domain.base.user.User
import com.jarroyo.daggerexampleapplication.domain.usecase.Response


sealed class GetProfileState {
    abstract val response: Response<User>?
}
data class SuccessGetProfileState(override val response: Response<User>) : GetProfileState()
data class LoadingGetProfileState(override val response: Response<User>? = null) : GetProfileState()
data class ErrorGetProfileState(override val response: Response<User>) : GetProfileState()