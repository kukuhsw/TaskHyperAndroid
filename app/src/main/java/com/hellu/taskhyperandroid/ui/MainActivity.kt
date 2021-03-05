package com.hellu.taskhyperandroid.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellu.taskhyperandroid.R
import com.hellu.taskhyperandroid.data.remote.ApiResponse
import com.hellu.taskhyperandroid.utils.ViewModelFactory
import com.hellu.taskhyperandroid.utils.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var usersAdapter: UserAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = obtainViewModel()

        initUserAdapter()
        getUserData()

    }

    private fun getUserData() {
        viewModel.getMeal().observe(this, Observer {
            when (it) {
                is ApiResponse.Success -> {
                    progressLayout.visibility = View.GONE
                    usersAdapter.setData(it.data)
                }
                is ApiResponse.Error -> showToast(it.errorMessage)
                is ApiResponse.Loading -> progressLayout.visibility = View.GONE
            }
        })
    }

    private fun initUserAdapter() {
        usersAdapter = UserAdapter()
        rvFoods.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = usersAdapter
        }
    }

    private fun obtainViewModel(): MainViewModel {
        return ViewModelFactory.getInstance(application).create(MainViewModel::class.java)
    }
}