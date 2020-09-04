package com.imaginatologintest.data.remote.model.request.login

import com.google.gson.annotations.SerializedName

data class LoginRequest(

    @field:SerializedName("username")
    var username: String = "",

    @field:SerializedName("password")
    var password: String = ""
)