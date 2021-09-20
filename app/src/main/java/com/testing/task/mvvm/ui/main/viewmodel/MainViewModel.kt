package com.testing.task.mvvm.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.testing.task.mvvm.data.model.User
import com.testing.task.mvvm.data.repository.MainRepository
import com.testing.task.mvvm.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val mainRepository: MainRepository,var condition:String) : ViewModel() {

    private val users = MutableLiveData<Resource<User>>()

    init {
        fetchUsers(condition)
    }

    private fun fetchUsers(condition: String) {
        users.postValue(Resource.loading(null))

            mainRepository.getUsers(condition).enqueue(object : Callback<User>{
                override fun onResponse(call: Call<User>, response: Response<User>) {
                  if (response.isSuccessful){
                      users.postValue(Resource.success(response.body()))
                  }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    users.postValue(Resource.error(t.localizedMessage,null))
                }
            })

    }

    override fun onCleared() {
        super.onCleared()

    }

    fun getUsers(): LiveData<Resource<User>> {
        return users
    }

}