package com.jarroyo.daggerexampleapplication.ui.viewModels.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jarroyo.daggerexampleapplication.domain.base.user.User
import com.jarroyo.daggerexampleapplication.domain.usecase.Response
import javax.inject.Inject

class ProfileViewModel
    @Inject
    constructor(
) : ViewModel() {

    var mGetProfileLiveData = MutableLiveData<GetProfileState>()

    companion object {
        var TAG = ProfileViewModel::class.java.simpleName
    }

    fun getProfile() {
        mGetProfileLiveData.postValue(LoadingGetProfileState())
    }


    /**
     * PROCESS GET PROFILE
     */
    fun processGetPlannedDosesListResponse(response: Response<User>){
        if (response is Response.Success) {
            mGetProfileLiveData.postValue(
                SuccessGetProfileState(
                    response
                )
            )
        } else if (response is Response.Error) {
            mGetProfileLiveData.postValue(
                ErrorGetProfileState(
                    response
                )
            )
        }
    }

}