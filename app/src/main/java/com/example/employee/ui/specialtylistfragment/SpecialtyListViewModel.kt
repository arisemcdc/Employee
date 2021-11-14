package com.example.employee.ui.specialtylistfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.employee.Employee

class SpecialtyListViewModel : ViewModel() {
    val employeesInfo = liveData {
        val data = Employee.repository.getEmployeesInfo()
        emit(data)
    }

}