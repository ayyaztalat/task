package com.testing.task.mvvm.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.testing.task.mvvm.data.api.ApiHelper
import com.testing.task.mvvm.data.repository.MainRepository
import com.testing.task.mvvm.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper,private val condition:String) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper),condition) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}