package com.testing.task.mvvm.data.repository

import com.testing.task.mvvm.data.api.ApiHelper
import com.testing.task.mvvm.data.model.User
import io.reactivex.Single
import retrofit2.Call

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(condition:String): Call<User> {
        return apiHelper.value(condition)
    }

}