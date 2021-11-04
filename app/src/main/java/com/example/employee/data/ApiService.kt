package com.example.employee.data

import com.example.employee.data.response.EmployeesInfo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

const val BASE_URL = "http://gitlab.65apps.com"
val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
interface ApiEmployeesService {
    @GET("/65gb/static/raw/master/testTask.json")
    suspend fun getEmployeesInfo(): EmployeesInfo
}
object EmployeesApi {
    val retrofitService: ApiEmployeesService by lazy {
        retrofit.create(ApiEmployeesService::class.java)
    }
}