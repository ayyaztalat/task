package com.testing.task.mvvm.data.api

import com.testing.task.mvvm.data.model.User
import retrofit2.Call

class ApiHelper(private val apiService: ApiService) {

    fun value(value_main:String): Call<User> {
        return apiService.querry(value_main)
    }

}