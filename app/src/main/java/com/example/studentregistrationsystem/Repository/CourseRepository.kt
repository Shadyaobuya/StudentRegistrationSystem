package com.example.studentregistrationsystem.Repository

import com.example.studentregistrationsystem.API.ApiClient
import com.example.studentregistrationsystem.API.ApiInterface
import com.example.studentregistrationsystem.Models.Courses
import com.example.studentregistrationsystem.UI.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CourseRepository {
    var response= ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun getCourses():
            Response<List<Courses>> = withContext(Dispatchers.IO){
                return@withContext response.getCourses(SessionManager.USER_TOKEN)
    }
}