package com.example.employee.data.response


import com.google.gson.annotations.SerializedName

data class Specialty(
    val name: String,
    @SerializedName("specialty_id")
    val specialtyId: Int
)