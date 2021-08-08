package com.example.studentregistrationsystem.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentregistrationsystem.Models.Courses
import com.example.studentregistrationsystem.R

class ViewCourseAdapter(var courseList:List<Courses>, var token:String):RecyclerView.Adapter<ViewCourseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewCourseViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.view_course_item,parent,false)
        return ViewCourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewCourseViewHolder, position: Int) {
        var currentCourse=courseList.get(position)
        holder.created.text=currentCourse.dateCreated
        holder.updated.text=currentCourse.dateUpdated
        holder.created_by.text=currentCourse.createdBy
        holder.updated_by.text=currentCourse.updatedBy
        holder.active.text=currentCourse.active
        holder.course_id.text=currentCourse.courseId
        holder.course_name.text=currentCourse.courseName
        holder.code.text=currentCourse.courseCode
        holder.description.text=currentCourse.description
        holder.instructor.text=currentCourse.instructor

    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}
class ViewCourseViewHolder(var itemView:View):RecyclerView.ViewHolder(itemView){
    var created=itemView.findViewById<TextView>(R.id.tvdateCreated)
    var updated=itemView.findViewById<TextView>(R.id.tvdateUpdated)
    var created_by=itemView.findViewById<TextView>(R.id.tvcreatedBy)
    var updated_by=itemView.findViewById<TextView>(R.id.tvupdatedby)
    var active=itemView.findViewById<TextView>(R.id.tvactive)
    var course_id=itemView.findViewById<TextView>(R.id.tvCourseid)
    var course_name=itemView.findViewById<TextView>(R.id.tvCourseName)
    var code=itemView.findViewById<TextView>(R.id.tvCourseCode)
    var description=itemView.findViewById<TextView>(R.id.tvDescription)
    var instructor=itemView.findViewById<TextView>(R.id.tvInstructor)
    var cdCourses=itemView.findViewById<CardView>(R.id.cdCourses)

}