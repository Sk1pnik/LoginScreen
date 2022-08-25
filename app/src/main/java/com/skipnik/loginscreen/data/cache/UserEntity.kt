package com.skipnik.loginscreen.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val userId: Int,
    val name: String,
    val phoneCode: String,
    val phoneNumber: String,
    val secondName: String
)