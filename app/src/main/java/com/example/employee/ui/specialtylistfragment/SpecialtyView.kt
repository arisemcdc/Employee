package com.example.employee.ui.specialtylistfragment

import com.example.employee.data.response.Specialty

interface SpecialtyView{
    fun updateView(specialties: List<Specialty>)
}

