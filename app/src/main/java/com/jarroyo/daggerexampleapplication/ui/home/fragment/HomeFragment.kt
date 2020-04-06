package com.jarroyo.daggerexampleapplication.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jarroyo.daggerexampleapplication.R
import com.jarroyo.daggerexampleapplication.ui.viewModels.home.*
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class HomeFragment : DaggerFragment() {

    @Inject
    lateinit var mProviderFactory: ViewModelProvider.Factory
    private lateinit var mProfileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configViewModel()
    }

    private fun configViewModel() {
        mProfileViewModel = ViewModelProvider(this, mProviderFactory).get(ProfileViewModel::class.java)
        mProfileViewModel.getProfile()
    }

    private fun subscribeObservers() {
        // We have to ermove on Fragments if you dont want a rare behaviour
        mProfileViewModel.mGetProfileLiveData.removeObservers(viewLifecycleOwner)
        mProfileViewModel.mGetProfileLiveData.observe(viewLifecycleOwner, getProfileStateObserver)
    }

    private val getProfileStateObserver = Observer<GetProfileState> { state ->
        state?.let {
            when (state) {
                is SuccessGetProfileState -> {
                }
                is LoadingGetProfileState -> {
                }
                is ErrorGetProfileState -> {
                }
            }
        }
    }
}
