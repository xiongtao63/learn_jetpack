package com.xiongtao.jetpack.lifecycle

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyLocationObserver(val context: Context) : LifecycleObserver {
    private lateinit var  locationManager:LocationManager
    lateinit var myLocationListener: MyLocationListener
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun startGetLocation(){
        Log.e("========","startGetLocation")
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        myLocationListener = MyLocationListener()
        if(ActivityCompat.checkSelfPermission(context,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            return
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,3000L,1f,myLocationListener)

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun stopGetLocation(){
        locationManager.removeUpdates(myLocationListener)
        Log.e("========","stopGetLocation")
    }

    class MyLocationListener : LocationListener{
        override fun onLocationChanged(location: Location) {
            Log.e("========","位置改变")
        }


    }
}