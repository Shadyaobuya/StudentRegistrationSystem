package com.example.studentregistrationsystem.UI

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
//    lateinit var sessionManager:SessionManager
    lateinit var sharedPref:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref=getSharedPreferences(Constants.SHAREDPREFS,Context.MODE_PRIVATE)
    }

    override fun onResume() {
        super.onResume()

       var token= sharedPref.getString(Constants.ACCESS_TOKEN,Constants.EMPTY_STRING)
        var bearer ="Bearer $token"
        if (token!!.isNotEmpty()){
            courseViewModel.viewCourses(bearer)
        }
        else{
            startActivity(Intent(baseContext,StudentLoginActivity::class.java))
        }
        binding.rvViewCourses.layoutManager=LinearLayoutManager(baseContext)

        courseViewModel.courseLiveData.observe(this, {course->
            if (!token.isNullOrEmpty()){
                 var courseAdapter=ViewCourseAdapter(course)
                binding.rvViewCourses.adapter=courseAdapter
            }

        })
        courseViewModel.courseFailedLiveData.observe(this,{ error->
            Toast.makeText(baseContext,error,Toast.LENGTH_SHORT).show()
        })

    }
}

