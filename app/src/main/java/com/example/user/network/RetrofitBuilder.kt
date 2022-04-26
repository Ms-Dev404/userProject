package com.example.user.network

import com.example.util.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {

  @Volatile
  var retrofit:Retrofit? = null


  fun build():Retrofit?{

   if(retrofit != null){

     return retrofit
   }
    synchronized(this) {

      retrofit = Retrofit.Builder().baseUrl(Constants.URL).client(getClient()).addConverterFactory(GsonConverterFactory.create()) .build()
    }


  return retrofit
  }

 private fun getClient() = OkHttpClient.Builder().callTimeout(20,TimeUnit.SECONDS).readTimeout(20,TimeUnit.SECONDS).build()
}