package com.example.user.network

import com.example.util.ApiSafeRequest
import com.example.util.AppLogger


class AppRepository(private val apiService: ApiService?):ApiSafeRequest() {

suspend fun getUsers()= executeRequest{
    apiService!!.getUserList(30) }

}
