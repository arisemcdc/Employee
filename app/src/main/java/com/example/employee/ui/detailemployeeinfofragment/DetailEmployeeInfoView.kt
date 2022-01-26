package com.example.employee.ui.detailemployeeinfofragment

import com.example.employee.data.response.Response

interface DetailEmployeeInfoView {
    fun updateView(employee: Response)
}