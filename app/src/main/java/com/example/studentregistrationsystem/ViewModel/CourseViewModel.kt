package com.example.studentregistrationsystem.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentregistrationsystem.Models.Courses
import com.example.studentregistrationsystem.Models.EnrollingResponse
import com.example.studentregistrationsystem.Models.LoginResponse
import com.example.studentregistrationsystem.Models.RegistrationRequest
import com.example.studentregistrationsystem.Repository.CourseRepository
import com.example.studentregistrationsystem.Repository.UserRepository
import kotlinx.coroutines.launch

class CourseViewModel:ViewModel() {
    var courseLiveData= MutableLiveData<List<Courses>>()
    var courseFailedLiveData= MutableLiveData<String>()

    var enrolCourseLiveData=MutableLiveData<EnrollingResponse>()
    var enrollcourseFailedData=MutableLiveData<String>()

    var viewcourseRepository= CourseRepository()

    fun viewCourses(accessToken:String){
        viewModelScope.launch {
            var response=viewcourseRepository.getCourses(accessToken)
            if (response.isSuccessful){
                courseLiveData.postValue(response.body())
            }
            else{
                courseFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

    fun EnrollStudent(accessToken: String){
        viewModelScope.launch {
            var response= viewcourseRepository.enrolStudentCourse(accessToken)
            if(response.isSuccessful){
                enrolCourseLiveData.postValue(response.body())
            }
            else{
                enrollcourseFailedData.postValue(response.errorBody()?.string())
            }
        }
    }
}

