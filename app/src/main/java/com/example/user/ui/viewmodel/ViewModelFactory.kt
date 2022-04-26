package com.example.user.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.util.MyApplication.Companion.repository

class ViewModelFactory:ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

      if(modelClass.isAssignableFrom(HomeViewModel::class.java)){

         return HomeViewModel(repository) as T
      }

     throw (Exception("Unknown class"))
    }
}