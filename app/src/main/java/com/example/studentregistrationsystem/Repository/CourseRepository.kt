package com.example.studentregistrationsystem.Repository

import com.example.studentregistrationsystem.API.ApiClient
import com.example.studentregistrationsystem.API.ApiInterface
import com.example.studentregistrationsystem.Models.Courses
import com.example.studentregistrationsystem.Models.EnrollingResponse
import com.example.studentregistrationsystem.UI.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CourseRepository {
    var apiInterface= ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun getCourses(accessToken:String):
            Response<List<Courses>> = withContext(Dispatchers.IO){
                var response =apiInterface.getCourses(accessToken)

                return@withContext response
    }

    suspend fun enrolStudentCourse(accessToken: String):
            Response<EnrollingResponse> = withContext(Dispatchers.IO){
                var response=apiInterface.enrollStudent(accessToken)
        return@withContext response

            }
}