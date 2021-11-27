package com.example.employee.ui.employeeslistfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.employee.Employee

class EmployeesListViewModel : ViewModel() {
     val employeesInfo = liveData {
       val data = Employee.repository.getEmployeesInfo()
       emit(data)
   }
}