package com.imaginatologintest.data.mapper

import com.google.gson.Gson
import com.imaginatologintest.data.remote.model.response.login.LoginResponse
import com.imaginatologintest.domain.model.LoginData
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class LogginMapper @Inject
constructor() {

    @Throws(IOException::class)
    fun transform(response: Response<ResponseBody>?): LoginData? {
        val loginResponse: LoginResponse
        if (response?.body() != null) {
            loginResponse = Gson().fromJson<Any>(response.body()!!.string(), LoginResponse::class.java) as LoginResponse
            return tranformLoginResponse(loginResponse)
        }
        return null;
    }

    fun tranformLoginResponse(loginResponse: LoginResponse): LoginData {
        val login = LoginData()
        login.errorMessage = loginResponse.errorMessage
        login.errorCode = loginResponse.errorCode
        return login
    }
}