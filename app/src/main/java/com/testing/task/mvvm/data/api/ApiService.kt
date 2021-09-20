package com.testing.task.mvvm.data.api

import com.testing.task.mvvm.data.model.User
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search.php?")
    fun querry(@Query("s")value:String):Call<User>



}