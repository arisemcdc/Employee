package com.example.employee.ui.specialtylistfragment

import com.example.employee.Employee
import com.example.employee.data.Repository.Repository
import com.example.employee.interfaces.MyInterface

class SpecialtyListPresenter (private val repository: Repository): MyInterface.Presenter {
    private val fragment: SpecialtyListFragment?=null
    override fun getData() {
        val data = Employee.repository.getEmployeesInfo()
                .response
                .flatMap { it.specialty }
                .distinctBy { it.specialtyId }


        emit(data)
        fragment.updateView(data)
    }
    //как ее в suspend превратить?
}