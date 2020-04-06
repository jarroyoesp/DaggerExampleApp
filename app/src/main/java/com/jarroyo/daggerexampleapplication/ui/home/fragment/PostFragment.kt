package com.jarroyo.daggerexampleapplication.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.jarroyo.daggerexampleapplication.R
import com.jarroyo.daggerexampleapplication.ui.viewModels.home.post.PostViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PostFragment : DaggerFragment() {

    @Inject
    lateinit var mProviderFactory: ViewModelProvider.Factory
    private lateinit var mPostViewModel: PostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configViewModel()

    }

    private fun configViewModel() {
        mPostViewModel = ViewModelProvider(this, mProviderFactory).get(PostViewModel::class.java)
        mPostViewModel.getPosts()
    }

}
