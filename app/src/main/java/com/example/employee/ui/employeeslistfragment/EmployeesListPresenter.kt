package com.example.employee.ui.employeeslistfragment

import com.example.employee.Employee
import com.example.employee.data.Repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class EmployeesListPresenter (private val repository: Repository): CoroutineScope {

    private var _specialtyId: Int? = null
    private var view: EmployeesView? = null
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    fun bind(view: EmployeesView) {
        this.view = view
    }

    fun unbind() {
        this.view = null
    }

    fun setSpecialtyId(id: Int) {
        _specialtyId = id
    }

    fun loadData() {
        launch {
            val data = Employee.repository.getEmployeesInfo() //надо как-то с датой разбираться как вытаскивать по нажатию....?
                    .response
                    .filter {
                        it.specialty.any {
                            it.specialtyId == 101
                        }
                    }
                   /* .distinctBy { it.specialty}*/
                    /*.filter { it.specialty = args}
                    .filter {it.specialty == args}*/

            /*val result = mutableListOf<Response>()
            for (i in data) {
                for (j in i.specialty)
                    if (j.specialtyId == 2) result.add(i)
            }
            return result*/
            withContext(Dispatchers.Main) {
                view?.updateView(data)
            }
        }
    }
}
