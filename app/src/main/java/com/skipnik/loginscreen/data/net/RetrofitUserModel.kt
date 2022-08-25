package com.skipnik.loginscreen.data.net

import com.google.gson.annotations.SerializedName

data class RetrofitUserModel(
    @SerializedName("phone_code") val phoneCode: String,
    @SerializedName("phone_number") val phoneNumber: String,
    @SerializedName("password") val password: String
)
