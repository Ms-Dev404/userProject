package com.example.user.network

import com.example.model.UserResponse
import com.example.util.Constants.USER_API
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

  @GET(USER_API)
  suspend fun getUserList(@Query("per_page")dataSize:Int):Response<UserResponse>

}
