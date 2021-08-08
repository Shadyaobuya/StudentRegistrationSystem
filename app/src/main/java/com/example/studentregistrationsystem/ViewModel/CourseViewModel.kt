package com.example.studentregistrationsystem.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentregistrationsystem.Models.Courses
import com.example.studentregistrationsystem.Models.LoginResponse
import com.example.studentregistrationsystem.Models.RegistrationRequest
import com.example.studentregistrationsystem.Repository.CourseRepository
import com.example.studentregistrationsystem.Repository.UserRepository
import kotlinx.coroutines.launch

class CourseViewModel:ViewModel() {
    var courseLiveData= MutableLiveData<List<Courses>>()
    var courseFailedLiveData= MutableLiveData<String>()

    var viewcourseRepository= CourseRepository()

    fun viewCourses(){
        viewModelScope.launch {
            var response=viewcourseRepository.getCourses()
            if (response.isSuccessful){
                courseLiveData.postValue(response.body())
            }
            else{
                courseFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}

