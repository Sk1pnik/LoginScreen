package com.skipnik.loginscreen.data.net

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SignInApi {

    @POST("/login")
    suspend fun login(
        @Body userModel: RetrofitUserModel
    ): UserModel

    companion object {
        const val BASE_URL = "https://tips-api-staging.crio-server.com"
    }
}