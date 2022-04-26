package com.example.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserResponse(@SerializedName("data") @Expose val users:ArrayList<UserDetails>,val error:String)
