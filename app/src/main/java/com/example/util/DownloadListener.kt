package com.example.util

interface DownloadListener {

  fun onDownloadStarted()

  fun onDownloadCompleted(mode:Boolean, fileName:String?)

  fun onDownloadError(e:Exception)

}