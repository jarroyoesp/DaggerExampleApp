package com.jarroyo.daggerexampleapplication.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.jarroyo.daggerexampleapplication.R
import com.jarroyo.daggerexampleapplication.ui.home.HomeActivity
import com.jarroyo.daggerexampleapplication.ui.viewModels.auth.AuthViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var mProviderFactory: ViewModelProvider.Factory

    private lateinit var mAuthViewModel: AuthViewModel

    @Inject
    lateinit var message: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        configViewModel()
        configView()
    }

    private fun configViewModel() {
        mAuthViewModel = ViewModelProvider(this, mProviderFactory).get(AuthViewModel::class.java)
        mAuthViewModel.getUser()
    }

    private fun configView() {
        activity_auth_button_navigate_to_home.setOnClickListener {
            navigateHome()
        }
    }

    private fun navigateHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    companion object {
        val TAG = AuthActivity::class.java.simpleName
    }
}
