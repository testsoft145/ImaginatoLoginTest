package com.imaginatologintest.presentation.login.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.imaginatologintest.R
import com.imaginatologintest.data.remote.model.request.login.LoginRequest
import com.imaginatologintest.domain.model.LoginData
import com.imaginatologintest.domain.usecase.LoginUseCase
import io.reactivex.subscribers.ResourceSubscriber
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    internal var mutableLoginLiveData = MutableLiveData<String>()

    fun callLogin(loginRequest: LoginRequest) {
        loginUseCase.executeFlowable(object : ResourceSubscriber<LoginData>() {
            override fun onNext(loginData: LoginData) {
                mutableLoginLiveData.postValue(loginData.errorMessage)
            }

            override fun onError(t: Throwable) {
                mutableLoginLiveData.postValue(t.localizedMessage)
            }

            override fun onComplete() {}
        }, LoginUseCase.Params(loginRequest.username, loginRequest.password))
    }

}