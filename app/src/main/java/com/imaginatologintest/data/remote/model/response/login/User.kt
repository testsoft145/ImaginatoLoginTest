package com.imaginatologintest.data.remote.model.response.login

import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("errorMessage")
    var errorMessage: String? = null

    @SerializedName("errorCode")
    var errorCode: Int = -1


}