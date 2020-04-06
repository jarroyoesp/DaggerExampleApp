package com.jarroyo.daggerexampleapplication.ui.viewModels.auth

import com.jarroyo.daggerexampleapplication.domain.base.user.User
import com.jarroyo.daggerexampleapplication.domain.usecase.Response


sealed class GetUserState {
    abstract val response: Response<User>?
}
data class SuccessGetAccountState(override val response: Response<User>) : GetUserState()
data class LoadingGetAccountState(override val response: Response<User>? = null) : GetUserState()
data class ErrorGetAccountState(override val response: Response<User>) : GetUserState()