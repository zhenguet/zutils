package com.zutils
import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.Callback
import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.checkSelfPermission

class ZutilsModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  private val CAMERA_PERMISSION_CODE = 1000
  private val IMAGE_CAPTURE_CODE = 1001
  private var imageUri: Uri? = null
  private var imageView: ImageView? = null

  override fun getName(): String {
    return NAME
  }

//   fun onCreateView(
//    inflater: LayoutInflater, container: ViewGroup?,
//    savedInstanceState: Bundle?
//  ): View? {
//    // Inflate the layout for this fragment
//    return inflater.inflate(R.layout.fragment_first, container, false)
//  }
//
//   fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//    if (requestCode === CAMERA_PERMISSION_CODE) {
//      if (grantResults.size === 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//        // Permission was granted
//        openCameraInterface()
//      }
//      else{
//        // Permission was denied
//        showAlert("Camera permission was denied. Unable to take a picture.");
//      }
//    }
//  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  fun multiply(a: Double, b: Double, promise: Promise) {
    promise.resolve(a * b)
  }

  @ReactMethod
  fun createCalendarEvent(name: String, location: String, callback: Callback) {
    Log.d("CalendarModule", "Create event called with name: $name and location: $location")
    val eventId = 1
    callback.invoke(null, eventId)
  }

  companion object {
    const val NAME = "Zutils"
  }
}
