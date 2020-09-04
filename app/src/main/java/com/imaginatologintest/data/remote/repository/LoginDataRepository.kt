package com.imaginatologintest.data.remote.repository

import android.content.Context
import com.imaginatologintest.data.local.db.LocalEntityData
import com.imaginatologintest.data.local.db.XaccData
import com.imaginatologintest.data.mapper.LogginMapper
import com.imaginatologintest.data.remote.entity.RemoteLoginEntityData
import com.imaginatologintest.domain.model.LoginData
import com.imaginatologintest.domain.repository.LoginRepository
import com.imaginatologintest.utility.AppConstants
import io.reactivex.Flowable

import javax.inject.Inject

class LoginDataRepository @Inject constructor(private val mapper: LogginMapper, private val context: Context) : LoginRepository {

    override fun postLogin(name: String, password: String): Flowable<LoginData> {
        return RemoteLoginEntityData(context).postLogin(name, password)!!.doOnNext { responseBodyResponse ->
            val xaccData = XaccData()
            xaccData.userName = name
            xaccData.xacc = responseBodyResponse.headers().get(AppConstants.KEY_HEADER_X_ACC)
            LocalEntityData(context).saveUserXaccToLocal(xaccData)
        }.map { responseBodyResponse -> mapper.transform(responseBodyResponse) }
    }


}