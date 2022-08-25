package com.skipnik.loginscreen.presentation.signin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.skipnik.loginscreen.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG = "BODY"

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    fun login(phoneNumber: String, password: String) = liveData {
        emit(repository.userLogin(phoneNumber, password))
    }
}

