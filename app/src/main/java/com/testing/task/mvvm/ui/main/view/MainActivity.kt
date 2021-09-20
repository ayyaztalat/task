package com.testing.task.mvvm.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.testing.task.mvvm.R
import com.testing.task.mvvm.data.api.ApiHelper
import com.testing.task.mvvm.data.api.ApiService
import com.testing.task.mvvm.data.api.ApiServiceImpl
import com.testing.task.mvvm.data.model.User
import com.testing.task.mvvm.ui.base.ViewModelFactory
import com.testing.task.mvvm.ui.main.adapter.MainAdapter
import com.testing.task.mvvm.ui.main.viewmodel.MainViewModel
import com.testing.task.mvvm.utils.Status
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: User) {
        adapter.addData(users.getDrinks())
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        val apiService =ApiServiceImpl.getClient(this)!!.create(ApiService::class.java)
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(apiService),"margarita")
        ).get(MainViewModel::class.java)
    }
}
