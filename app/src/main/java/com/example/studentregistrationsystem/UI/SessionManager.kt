package com.example.studentregistrationsystem.UI

import android.content.Context
import android.content.SharedPreferences
import com.example.studentregistrationsystem.Models.Courses
import com.example.studentregistrationsystem.R
import java.security.AccessControlContext
import com.example.studentregistrationsystem.Models.LoginResponse

class SessionManager(context : Context) {
    private var sharedPrefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name),
            Context.MODE_PRIVATE)
    companion object {
        const val USER_TOKEN="access_token"

    }
    fun saveAuthToken(token: String) {
        val editor = sharedPrefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }
    fun fetchAuthToken(): String? {
        return sharedPrefs.getString(USER_TOKEN, null)
    }




}

