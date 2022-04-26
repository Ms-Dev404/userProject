package com.example.util

import android.util.Log

object AppLogger {

const val TAG = "wallpaper"

fun logDebug(message:String){

  Log.d(TAG,message)
}

fun logError(message:String){

    Log.e(TAG,message)
}

fun logVerbose(message:String){

        Log.v(TAG,message)
    }

fun logInfo(message:String){

        Log.i(TAG,message)
    }

}


