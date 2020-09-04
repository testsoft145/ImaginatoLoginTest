package com.imaginatologintest.data.remote.intercepter

import android.content.Context
import com.imaginatologintest.R
import com.imaginatologintest.utility.NetworkUtils
import okhttp3.Interceptor
import okhttp3.Response
import test.app.com.logintest.data.remote.execeptions.NetworkNotFoundException
import java.io.IOException

class NetworkInterceptor(private val context: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (NetworkUtils.hasNetwork(context)) {
            return chain.proceed(request)
        }
        throw NetworkNotFoundException(context.getString(R.string.no_internet))
    }

}