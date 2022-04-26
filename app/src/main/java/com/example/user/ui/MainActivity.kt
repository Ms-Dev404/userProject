package com.example.user.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.model.UserDetails
import com.example.util.showToast

import com.example.user.databinding.ActivityMainBinding
import com.example.user.ui.viewmodel.HomeViewModel
import com.example.user.ui.viewmodel.ViewModelFactory
import com.example.util.AppLogger


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userAdapter = UserAdapter()
    private var usersList = ArrayList<UserDetails>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUsers.apply {

            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
        }

        val factory = ViewModelFactory()
        val homeViewModel = ViewModelProvider(this,factory)[HomeViewModel::class.java]

        binding.buttonRetry.setOnClickListener {

          homeViewModel.getList()
            binding.pbload.visibility=View.VISIBLE
        }

        binding.tvData.setOnClickListener {
            homeViewModel.getList()
        }

        homeViewModel.userList.observeForever {
               binding.pbload.isVisible = false
               if(it.users.isNotEmpty()) {


                   binding.buttonRetry.isVisible = false

               }

               userAdapter.setData(it.users)

                   showToast(it.error)
                   binding.buttonRetry.isVisible = it.error.isNotEmpty()








        }


    }


}