package com.example.employee.ui.employeeslistfragment

import com.example.employee.Employee
import com.example.employee.data.response.Response

interface EmployeesView {
    fun updateView(employees: List<Response>)
}