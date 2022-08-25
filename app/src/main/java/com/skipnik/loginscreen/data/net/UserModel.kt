package com.skipnik.loginscreen.data.net

import com.skipnik.loginscreen.data.cache.UserEntity

data class UserModel(
    val user: User
)

fun UserModel.map(): UserEntity {
    user.apply {
        return UserEntity(
            userId = this.userId,
            name = this.name,
            phoneCode = this.phoneCode,
            phoneNumber = this.phoneNumber,
            secondName = this.secondName
        )
    }

}