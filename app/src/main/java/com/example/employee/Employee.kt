package com.example.employee

import android.app.Application
import com.example.employee.data.Repository.Repository

class Employee: Application() {
    companion object {
        lateinit var repository: Repository
    }

    override fun onCreate() {
        super.onCreate()
        repository = Repository()
    }
}