package com.imaginatologintest.domain.repository

import com.imaginatologintest.domain.model.LoginData
import io.reactivex.Flowable

interface LoginRepository {
    fun postLogin(name: String, password: String): Flowable<LoginData>
}