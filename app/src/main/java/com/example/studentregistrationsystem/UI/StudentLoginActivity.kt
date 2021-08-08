package com.example.studentregistrationsystem.UI

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.se.omapi.Session
import android.widget.Toast
import androidx.activity.viewModels
import com.example.studentregistrationsystem.Models.LoginRequest
import com.example.studentregistrationsystem.Models.LoginResponse
import com.example.studentregistrationsystem.Models.RegistrationRequest
import com.example.studentregistrationsystem.R
import com.example.studentregistrationsystem.ViewModel.UserViewModel
import com.example.studentregistrationsystem.databinding.ActivityStudentLoginBinding

class StudentLoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityStudentLoginBinding
    lateinit var sessionManager: SessionManager



    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityStudentLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

       sessionManager = SessionManager(baseContext)

        binding.btnLogMeIn.setOnClickListener {
            var email=binding.etmail.text.toString()
            var password=binding.etpassword.text.toString()
            var loginRequest=LoginRequest(
                email=email,
                password=password
            )
            userViewModel.loginStudent(loginRequest)
        }
        userViewModel.loginLiveData.observe(this,{loginResponse ->
            if (!loginResponse.studentId.isNullOrEmpty() && !loginResponse.accessToken.isNullOrEmpty()){
                sessionManager.fetchAuthToken()
                Toast.makeText(baseContext,"Successful Login",Toast.LENGTH_SHORT).show()
                var intent=Intent(baseContext,ViewCoursesActivity::class.java)
                startActivity(intent)
            }
        })
        userViewModel.loginFailedLiveData.observe(this, {error ->
            Toast.makeText(baseContext,error,Toast.LENGTH_SHORT).show()
        })
    }
}

