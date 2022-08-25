package com.skipnik.loginscreen.di

import android.app.Application
import androidx.room.Room
import com.skipnik.loginscreen.Utils.getUnsafeOkHttpClient
import com.skipnik.loginscreen.data.cache.UserDatabase
import com.skipnik.loginscreen.data.net.SignInApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(SignInApi.BASE_URL)
            .client(getUnsafeOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideSignInApi(retrofit: Retrofit): SignInApi =
        retrofit.create(SignInApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): UserDatabase =
        Room.databaseBuilder(
            app,
            UserDatabase::class.java,
            "user_database"
        ).build()

}