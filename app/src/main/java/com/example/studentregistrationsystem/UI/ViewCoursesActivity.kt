package com.example.studentregistrationsystem.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentregistrationsystem.Repository.CourseRepository
import com.example.studentregistrationsystem.ViewModel.CourseViewModel
import com.example.studentregistrationsystem.ViewModel.UserViewModel
import com.example.studentregistrationsystem.databinding.ActivityViewCoursesBinding

class ViewCoursesActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewCoursesBinding
    val courseViewModel: CourseViewModel by viewModels()
    lateinit var sessionManager:SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        sessionManager = SessionManager(baseContext)

       var token= sessionManager.fetchAuthToken().toString()

        courseViewModel.courseLiveData.observe(this, {course->
            if (!course.isNullOrEmpty()){
                binding.rvViewCourses.layoutManager=LinearLayoutManager(baseContext)
                 var courseAdapter=ViewCourseAdapter(courseList =course,token )
                binding.rvViewCourses.adapter=courseAdapter
            }

        })
        courseViewModel.courseFailedLiveData.observe(this,{ error->
            Toast.makeText(baseContext,error,Toast.LENGTH_SHORT).show()
        })

    }
}

