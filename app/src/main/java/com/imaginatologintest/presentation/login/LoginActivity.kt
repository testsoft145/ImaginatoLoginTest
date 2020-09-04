package com.imaginatologintest.presentation.login

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.imaginatologintest.databinding.ActivityLoginBinding
import com.imaginatologintest.presentation.base.BaseActivity
import com.imaginatologintest.R
import com.imaginatologintest.data.remote.model.request.login.LoginRequest
import com.imaginatologintest.presentation.login.viewmodel.LoginViewModel
import javax.inject.Inject


class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private var loginViewModel: LoginViewModel? = null

    private lateinit var context: Context

    override val layout: Int = R.layout.activity_login

    override fun initActivity() {
        context = this@LoginActivity
    }

    override fun viewSetup() {
        binding.loginData = LoginRequest()
    }

    override fun viewModelSetup() {
        loginViewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
    }

    override fun observers() {
        loginViewModel?.mutableLoginLiveData?.observe(this, Observer {
            dismissLoader()
            Toast.makeText(this@LoginActivity, it, Toast.LENGTH_SHORT).show()
        })
    }

    fun login(v: View) {
        showLoader()
        if (checkValidation()) {
            loginViewModel?.checkValidationAndCallLoginWs(context, binding.loginData!!)
        }
    }

    private fun checkValidation(): Boolean {
        if (binding.loginData != null) {
            if (binding.loginData!!.username.isEmpty()) {
                binding.loginUsernameHint.error = getString(R.string.enter_username)
                return false
            } else if (binding.loginData!!.password.isEmpty()) {
                binding.loginPasswordHint.error = getString(R.string.enter_password)
                return false
            }
        }
        return true
    }

}