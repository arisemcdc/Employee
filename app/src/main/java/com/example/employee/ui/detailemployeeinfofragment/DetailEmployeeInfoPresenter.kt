package com.example.employee.ui.detailemployeeinfofragment

import com.example.employee.data.Repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class DetailEmployeeInfoPresenter (private val repository: Repository): CoroutineScope {

    private var view: DetailEmployeeInfoView? = null
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    fun bind(view: DetailEmployeeInfoView) {
        this.view = view
    }

    fun unbind() {
        this.view = null
    }
}