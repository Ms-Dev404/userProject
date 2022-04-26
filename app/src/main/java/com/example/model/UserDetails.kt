package com.example.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserDetails(@SerializedName("id")  @Expose val id:Int, @SerializedName("email") @Expose val email:String, @SerializedName("first_name") @Expose val firstName:String, @SerializedName("last_name") @Expose val lastName:String, @SerializedName("avatar") @Expose val avatar:String)