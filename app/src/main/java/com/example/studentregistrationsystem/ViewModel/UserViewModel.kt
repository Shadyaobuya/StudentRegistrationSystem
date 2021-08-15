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
    //observes data and updates UI in realtime
    //waits for it to change and updates UI
    var registrationLiveData=MutableLiveData<RegistrationResponse>()
    var registrationFailedLiveData=MutableLiveData<String>()

    var loginLiveData= MutableLiveData<LoginResponse>()
    var loginFailedLiveData= MutableLiveData<String>()

    var userRepository=UserRepository()
//create a function
    //called in the registration activity
    //takes a registration request
    fun registerStudent(registrationRequest: RegistrationRequest){

    //triggers call to coroutine
        viewModelScope.launch {
            var response=userRepository.registerStudent(registrationRequest)
            if (response.isSuccessful){
                registrationLiveData.postValue(response.body())
            }
            else{
                //update UI incase of an error
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
