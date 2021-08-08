package com.example.studentregistrationsystem.Models

import com.google.gson.annotations.SerializedName

data class Courses(
    @SerializedName("date_created") var dateCreated:String,
    @SerializedName("date_updated") var dateUpdated:String,
    @SerializedName("created_by") var createdBy:String,
    @SerializedName("updated_by") var updatedBy:String,
    var active:String,
    @SerializedName("course_id") var courseId:String,
    @SerializedName("course_name") var courseName:String,
    @SerializedName("course_code") var courseCode:String,
    var description:String,
    var instructor:String,
)