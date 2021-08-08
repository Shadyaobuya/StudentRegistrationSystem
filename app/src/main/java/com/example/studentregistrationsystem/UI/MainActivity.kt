package com.example.studentregistrationsystem.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.studentregistrationsystem.R
import com.example.studentregistrationsystem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.nextPageIcon.setOnClickListener {
            var intent=Intent(baseContext,StudentRegistration::class.java)
            startActivity(intent)
        }
    }
}