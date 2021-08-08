package com.example.studentregistrationsystem.ViewModel

import androidx.lifecycle.MutableLiveData
import com.example.studentregistrationsystem.Models.LoginRequest
import com.example.studentregistrationsystem.Models.RegistrationRequest
import com.example.studentregistrationsystem.Models.RegistrationResponse
import com.example.studentregistrationsystem.Repository.UserRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentregistrationsystem.Models.LoginResponse
import kotlinx.coroutines.launch


class UserViewModel:ViewModel() {
    var registrationLiveData=MutableLiveData<RegistrationResponse>()
    var registrationFailedLiveData=MutableLiveData<String>()

    var loginLiveData= MutableLiveData<LoginResponse>()
    var loginFailedLiveData= MutableLiveData<String>()

    var userRepository=UserRepository()

    fun registerStudent(registrationRequest: RegistrationRequest){
        viewModelScope.launch {
            var response=userRepository.registerStudent(registrationRequest)
            if (response.isSuccessful){
                registrationLiveData.postValue(response.body())
            }
            else{
                registrationFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
    fun loginStudent(loginRequest: LoginRequest){
        viewModelScope.launch {
            var response=userRepository.loginStudent(loginRequest)
            if (response.isSuccessful){
                loginLiveData.postValue(response.body())
            }
            else{
                loginFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }



}
