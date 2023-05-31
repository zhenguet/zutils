package com.zutils
import android.util.Log
import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ZutilsModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

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

  @ReactMethod
  fun getCurrentDate(callback: Callback) {
    try {
      val dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss")
      val now = LocalDateTime.now()

      Log.d("Check", "Now: $now")

      callback.invoke(null, dtf.format(now))

    } catch (e1: Exception) {
      Log.d("DEBUG", "ERROR: $e1")
    }
  }

  companion object {
    const val NAME = "Zutils"
  }
}
