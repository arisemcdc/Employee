package com.example.employee.data

import android.util.Log
import kotlinx.coroutines.runBlocking
import org.junit.Test

class EmployeesApiTest {
    @Test
    fun getEpmloyeesInfo(): Unit = runBlocking {
        val data = EmployeesApi.retrofitService.getEmployeesInfo()
        Log.d("myLog", data.toString())
    }
}