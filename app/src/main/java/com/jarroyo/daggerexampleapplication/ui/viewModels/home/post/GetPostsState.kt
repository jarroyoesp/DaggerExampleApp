package com.jarroyo.daggerexampleapplication.ui.viewModels.home.post

import com.jarroyo.daggerexampleapplication.domain.base.post.Post
import com.jarroyo.daggerexampleapplication.domain.usecase.Response


sealed class GetPostsState {
    abstract val response: Response<List<Post>>?
}
data class SuccessGetPostsState(override val response: Response<List<Post>>) : GetPostsState()
data class LoadingGetPostsState(override val response: Response<List<Post>>? = null) : GetPostsState()
data class ErrorGetPostsState(override val response: Response<List<Post>>) : GetPostsState()