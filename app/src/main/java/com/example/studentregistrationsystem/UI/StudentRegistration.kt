package com.example.studentregistrationsystem.UI

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.studentregistrationsystem.Models.RegistrationRequest
import com.example.studentregistrationsystem.Models.RegistrationResponse

import com.example.studentregistrationsystem.ViewModel.UserViewModel
import com.example.studentregistrationsystem.databinding.ActivityStudentRegistrationBinding

class StudentRegistration : AppCompatActivity() {
    lateinit var binding: ActivityStudentRegistrationBinding
    //factory pattern of instantiating 1 instance of object to exist at  a time
    //creating an object with abstraction from user
    lateinit var sharedPref:SharedPreferences
    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStudentRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref=getSharedPreferences(Constants.SHAREDPREFS,Context.MODE_PRIVATE)
        redirectUser()
    }
    fun redirectUser(){
        var accessToken=sharedPref.getString(Constants.ACCESS_TOKEN,Constants.EMPTY_STRING)
        if (accessToken!!.isNotEmpty()){
            startActivity(Intent(baseContext,ViewCoursesActivity::class.java))
        }else{
            startActivity(Intent(baseContext,StudentLoginActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        binding.btnRegister.setOnClickListener {
            registerStudent()




        }

    }

    fun registerStudent(){
        var nationalities= arrayOf("KENYAN","UGANDAN","RWANDAN","SOUTH SUDAN")
        var nationalityAdapter=ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,nationalities)
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spnationality.adapter=nationalityAdapter

        var name=binding.etName.text.toString()
        var email=binding.etEmail.text.toString()
        var dob=binding.etDob.text.toString()
        var password=binding.etPassword.text.toString()
        var nationality=binding.spnationality.selectedItem.toString()
        var phonenumber=binding.etPhone.text.toString()

        var registrationRequest=RegistrationRequest(
            name=name,
            email=email,
            dateOfBirth = dob,
            password = password,
            nationality = nationality,
            phoneNumber = phonenumber
        )
        userViewModel.registerStudent(registrationRequest)

        userViewModel.registrationLiveData.observe(this, {registrationResponse->
            if (!registrationResponse.studentId.isNullOrEmpty()){
                Toast.makeText(baseContext,"Successful Registration",Toast.LENGTH_LONG).show()

            }
        })
        userViewModel.registrationFailedLiveData.observe(this, { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_SHORT).show()
        })

        binding.btnLogin.setOnClickListener {
            var intent=Intent(baseContext,StudentLoginActivity::class.java)
            startActivity(intent)

        }
    }
}