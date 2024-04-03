package com.example.method_channel_flutter

import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.SupportMapFragment
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val CHANNEL = "flutter.native/helper"

    @ExperimentalStdlibApi
    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler{
                call, result ->
            when {
                call.method.equals("changeColor") -> {
                    changeColor(call,result)
                }
                call.method.equals("openGoogleMaps") -> {
                    openMaps(call,result)
                }
            }
        }
    }
    private fun openMaps(call: MethodCall, result: MethodChannel.Result){
        val intent= Intent(this,MapsActivity::class.java)
        startActivity(intent)
        result.success("ActivityStarted")
    }
    private fun changeColor(call: MethodCall, result: MethodChannel.Result) {
        val color = call.argument<String>("color")
        result.success(color)
    }

}
