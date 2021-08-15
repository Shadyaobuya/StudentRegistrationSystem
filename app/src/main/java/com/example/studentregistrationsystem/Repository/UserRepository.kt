package com.example.studentregistrationsystem.Repository

import com.example.studentregistrationsystem.API.ApiClient
import com.example.studentregistrationsystem.API.ApiInterface
import com.example.studentregistrationsystem.Models.LoginRequest
import com.example.studentregistrationsystem.Models.LoginResponse
import com.example.studentregistrationsystem.Models.RegistrationRequest
import com.example.studentregistrationsystem.Models.RegistrationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
//steps
class UserRepository {
    //takes data from view model and makes call to API
    //1.create instance of API interface
    var apiInterface=ApiClient.buildApiClient(ApiInterface::class.java)
    //2. create a suspend function to register student
    suspend fun registerStudent(registrationRequest: RegistrationRequest):
            //inline function->assigned
            //coroutine instance of suspendable function
            //dispatcher is resonsible for switching context from UI to IO thread
            Response<RegistrationResponse> = withContext(Dispatchers.IO){
               var response=apiInterface.registerStudent(registrationRequest)
                   return@withContext response
    }
    suspend fun loginStudent(loginRequest: LoginRequest):
            Response<LoginResponse> = withContext(Dispatchers.IO){
        var response=apiInterface.loginStudent(loginRequest)
                return@withContext response
    }
}