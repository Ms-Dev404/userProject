package com.example.user.ui.viewmodel


import androidx.lifecycle.*
import com.example.model.UserResponse
import com.example.util.AppLogger
import com.example.user.network.AppRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel(private val repository: AppRepository?) : ViewModel() {
 private val set_userList = MutableLiveData<UserResponse>()
 val userList: LiveData<UserResponse> get() = set_userList


 init {

 getList()

 }


 fun getList(){

  viewModelScope.launch {
   try {


   set_userList.value = repository!!.getUsers()


  }catch (e:Exception){

   AppLogger.logError(e.stackTraceToString())
   set_userList.value = UserResponse(arrayListOf(),e.localizedMessage)
   }

  }
 }

 override fun onCleared() {
  super.onCleared()


 }


}