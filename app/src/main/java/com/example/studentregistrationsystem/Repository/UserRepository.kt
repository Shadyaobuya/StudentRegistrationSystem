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

class UserRepository {
    var response=ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun registerStudent(registrationRequest: RegistrationRequest):
            Response<RegistrationResponse> = withContext(Dispatchers.IO){
                return@withContext response.registerStudent(registrationRequest)
    }
    suspend fun loginStudent(loginRequest: LoginRequest):
            Response<LoginResponse> = withContext(Dispatchers.IO){
                return@withContext response.loginStudent(loginRequest)
    }
}