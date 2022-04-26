package com.example.util

import android.app.Application

import com.example.user.network.ApiService
import com.example.user.network.AppRepository
import com.example.user.network.RetrofitBuilder



class MyApplication:Application() {

  companion object {

    var repository: AppRepository? =null


  }

   private var apiService: ApiService? = null


    override fun onCreate() {
        super.onCreate()

         apiService = apiService?:RetrofitBuilder.build()!!.create(ApiService::class.java)

         repository = repository ?: AppRepository(apiService)


    }

    override fun onTerminate() {

        super.onTerminate()
        apiService = null
        repository = null



    }


}