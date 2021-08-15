package com.example.studentregistrationsystem.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.studentregistrationsystem.R
import com.example.studentregistrationsystem.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Picasso.get().load("http://unblast.com/wp-content/uploads/2020/05/Back-to-School-Illustration.jpg").into(binding.imageView)
        binding.nextPageIcon.setOnClickListener {
            var intent=Intent(baseContext,StudentRegistration::class.java)
            startActivity(intent)
        }
    }
}