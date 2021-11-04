package com.example.employee.data.response


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("avatr_url")
    val avatrUrl: String,
    val birthday: String,
    @SerializedName("f_name")
    val fName: String,
    @SerializedName("l_name")
    val lName: String,
    val specialty: List<Specialty>
)