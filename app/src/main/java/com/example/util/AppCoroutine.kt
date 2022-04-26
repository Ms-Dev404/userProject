package com.example.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object AppCoroutine {

 fun run(execute:suspend ()->Unit)= CoroutineScope(Dispatchers.Main).launch{

   execute()
}

}