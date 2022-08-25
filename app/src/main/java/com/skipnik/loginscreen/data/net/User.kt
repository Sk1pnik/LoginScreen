package com.skipnik.loginscreen.data.net

import com.google.gson.annotations.SerializedName

data class User(
    val name: String,
    @SerializedName("phone_code") val phoneCode: String,
    @SerializedName("phone_number") val phoneNumber: String,
    @SerializedName("second_name") val secondName: String,
    @SerializedName("user_id") val userId: Int
)