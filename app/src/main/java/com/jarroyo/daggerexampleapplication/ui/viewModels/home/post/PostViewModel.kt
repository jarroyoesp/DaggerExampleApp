package com.jarroyo.daggerexampleapplication.ui.viewModels.home.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jarroyo.daggerexampleapplication.domain.base.post.Post
import com.jarroyo.daggerexampleapplication.domain.usecase.Response
import javax.inject.Inject

class PostViewModel
    @Inject
    constructor(
) : ViewModel() {

    var mGetPostsLiveData = MutableLiveData<GetPostsState>()

    companion object {
        var TAG = PostViewModel::class.java.simpleName
    }

    fun getPosts() {
        mGetPostsLiveData.postValue(LoadingGetPostsState())
    }


    /**
     * PROCESS GET PROFILE
     */
    fun processGetPlannedDosesListResponse(response: Response<List<Post>>){
        if (response is Response.Success) {
            mGetPostsLiveData.postValue(
                SuccessGetPostsState(
                    response
                )
            )
        } else if (response is Response.Error) {
            mGetPostsLiveData.postValue(
                ErrorGetPostsState(
                    response
                )
            )
        }
    }

}