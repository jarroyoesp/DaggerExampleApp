package com.jarroyo.daggerexampleapplication.ui.viewModels.auth

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarroyo.daggerexampleapplication.data.repository.user.UserRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel
    @Inject
    constructor(
        val mUserRepository: UserRepository
) : ViewModel() {

    companion object {
        var TAG = AuthViewModel::class.java.simpleName
    }

    var mGetUserLiveData = MutableLiveData<GetUserState>()

    fun getUser() {
        mGetUserLiveData.postValue(LoadingGetAccountState())

        Log.d(TAG, "getUser")
        viewModelScope.launch {
            val flowUser = mUserRepository.getAccount()
            flowUser.collect {
                Log.d(TAG, "User: "+it.toString())
            }


        }
    }

}