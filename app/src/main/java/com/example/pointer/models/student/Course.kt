package com.example.pointer.models.student

class Course {
    var courseName:String?=null
    var childCourseList:ArrayList<String>?=null

    constructor(courseName: String?, childCourseList: ArrayList<String>?) {
        this.courseName = courseName
        this.childCourseList = childCourseList
    }
}