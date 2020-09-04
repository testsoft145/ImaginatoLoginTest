package com.imaginatologintest.data.local.db

import android.content.Context
import com.imaginatologintest.data.local.db.BasePersistence
import com.imaginatologintest.data.remote.entity.login.LoginEntityData
import io.reactivex.Flowable
import okhttp3.ResponseBody
import retrofit2.Response

class LocalEntityData(context: Context) : BasePersistence(context),
    LoginEntityData {

    override fun postLogin(name: String, password: String): Flowable<Response<ResponseBody>>? {
        return null
    }

    override fun saveUserXaccToLocal(xaccData: XaccData) {
        db!!.loginDao.insertXaccData(xaccData)
    }
}