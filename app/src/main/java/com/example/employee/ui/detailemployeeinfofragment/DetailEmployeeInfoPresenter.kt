package com.example.employee.ui.detailemployeeinfofragment

import com.example.employee.Employee
import com.example.employee.data.Repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class DetailEmployeeInfoPresenter (private val repository: Repository): CoroutineScope {

    private var _avatrUrl: String? = null
    private var view: DetailEmployeeInfoView? = null
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    fun bind(view: DetailEmployeeInfoView) {
        this.view = view
    }

    fun unbind() {
        this.view = null
    }

    fun setAvatrUrl(id: String) {
        _avatrUrl = id
    }

    fun loadData() {
        launch {
            val data = Employee.repository.getEmployeesInfo() //надо как-то с датой разбираться как вытаскивать по нажатию....?
                    .response.find { it.avatrUrl == _avatrUrl}

            withContext(Dispatchers.Main) {
                view?.updateView(data!!)
            }
        }
    }
}