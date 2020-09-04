package com.imaginatologintest.presentation.login

import android.util.Log
import android.view.View
import com.imaginatologintest.databinding.ActivityLoginBinding
import com.imaginatologintest.presentation.base.BaseActivity
import com.imaginatologintest.R
import com.imaginatologintest.data.remote.login.model.LoginRequest


class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    override val layout: Int = R.layout.activity_login

    override fun viewModelSetup() {
    }

    override fun viewSetup() {
        binding.loginData = LoginRequest()
    }

    fun login(view: View) {
    }
}