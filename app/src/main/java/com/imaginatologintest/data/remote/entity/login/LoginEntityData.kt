package com.imaginatologintest.data.remote.entity.login

import io.reactivex.Flowable
import okhttp3.ResponseBody
import retrofit2.Response

interface LoginEntityData {

    fun postLogin(name: String, password: String): Flowable<Response<ResponseBody>>?

//    fun saveUserXaccToLocal(xaccData: XaccData)

}