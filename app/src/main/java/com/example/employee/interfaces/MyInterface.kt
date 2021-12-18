package com.example.employee.interfaces

import com.example.employee.data.response.Specialty

class MyInterface {
    interface DataView {
        fun getDataFromPresenter(value: List<Specialty>)
    }
    interface Presenter {
        fun getData()
    }
    interface specialtyView{
        fun updateView()
    }
    interface ModelInterface {
        fun getValue(): List<Specialty>
    }
}