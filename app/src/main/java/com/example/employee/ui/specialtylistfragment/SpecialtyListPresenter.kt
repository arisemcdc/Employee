package com.example.employee.ui.specialtylistfragment

import com.example.employee.Employee
import com.example.employee.data.Repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class SpecialtyListPresenter (private val repository: Repository): CoroutineScope {

    private var view: SpecialtyView?=null
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    fun bind(view: SpecialtyView) {
        this.view = view
    }

    fun unbind() {
        this.view = null
    }

    fun loadData() {
        launch {
            /*val data = Employee.repository.getEmployeesInfo()
                    .response
                    .flatMap { it.specialty }
                    .distinctBy { it.specialtyId }*/

            val data = Employee.repository.getEmployeesInfo()
                    .response
                    .flatMap { it.specialty }
                    .distinctBy { it.specialtyId }

            withContext(Dispatchers.Main) {
                view?.updateView(data)
            }
        }
    }


    //как ее в suspend превратить?
}