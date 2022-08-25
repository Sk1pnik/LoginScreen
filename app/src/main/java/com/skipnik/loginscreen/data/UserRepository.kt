package com.skipnik.loginscreen.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData

import com.skipnik.loginscreen.data.cache.UserDatabase
import com.skipnik.loginscreen.data.cache.UserEntity
import com.skipnik.loginscreen.data.net.RetrofitUserModel
import com.skipnik.loginscreen.data.net.SignInApi
import com.skipnik.loginscreen.data.net.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val api: SignInApi,
    private val db: UserDatabase,
) {
    private val userDao = db.userDao()

    suspend fun userLogin(
        phoneNumber: String,
        password: String,
    ): Int? {
//        disableSSLCertificateChecking()
        return try {
            val result = api.login(loginData(phoneNumber, password)).map()
            userDao.addUser(result)
            result.userId
        } catch (e: Exception) {
            Log.d("BODY", e.toString())
            null
        }
    }

    fun userData(id: Int): LiveData<UserEntity> {
        return userDao.getUser(id).asLiveData()
    }

    private fun loginData(phoneNumber: String, password: String): RetrofitUserModel {
        val phoneCode = phoneNumber.take(4)
        val secondPart = phoneNumber.takeLast(9)
        return RetrofitUserModel(
            phoneCode,
            secondPart,
            password
        )
    }


}