package com.skipnik.loginscreen.presentation.profile


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.skipnik.loginscreen.data.UserRepository
import com.skipnik.loginscreen.data.cache.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: UserRepository,
) : ViewModel() {

    fun userData(id: Int): LiveData<UserEntity> {
        return repository.userData(id)
    }
}

