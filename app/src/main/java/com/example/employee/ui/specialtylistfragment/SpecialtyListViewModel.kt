package com.example.employee.ui.specialtylistfragment

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.employee.Employee
import com.example.employee.data.response.Response
import com.example.employee.data.response.Specialty

/*
class SpecialtyListViewModel : ViewModel() {
    val employeesInfo = liveData {
        val data = Employee.repository.getEmployeesInfo()
        emit(data)
    }
    val specialties = Transformations.map(employeesInfo) {
        it.response
    }
    val specialtyList = Transformations.map(specialties) {
        it[0]
    }
    fun fillSpecialtyList(): List<Specialty> {
        val specialtyList = arrayListOf<Specialty>()
        for (....)
        return specialtyList
    }
}*/
class SpecialtyListViewModel : ViewModel() {
    val employeesInfo = liveData {
        val data = Employee.repository.getEmployeesInfo()
        emit(data)
    }
    val listResponse = Transformations.map(employeesInfo) {
        it.response
    }
    /*val specialtyList = Transformations.map(listResponse) {
        it.forEach {
            val specialty = it.specialty
        }
    }*/

    val specialtyList = Transformations.map(listResponse) {
        it.flatMap {
            it.specialty.map {
                it.name
            }
        }
    }
    
    }

    /*fun convertSpecialtyClass(response: List <Response>): List <Specialty>{
        val newList = mutableListOf<Specialty>()
        response.forEach {
            *//*newList += Specialty(it.specialty[0].name.toString(), 1)*//*
            newList += Specialty(it.specialty[])
        }
        return newList
    }*/
   /*//использование функции карты
    fun convertSpecialtyClass(listResponse: <Response>) = listResponse.map {

    }*/
}
