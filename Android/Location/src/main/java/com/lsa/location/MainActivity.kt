package com.lsa.location

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnSuccessListener

class MainActivity : AppCompatActivity() {

    private lateinit var apiClient: GoogleApiClient
    private val requestLocationCode = 1234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val connectionCallback = object : GoogleApiClient.ConnectionCallbacks {
            override fun onConnected(p0: Bundle?) {
                // 위치 제공자를 사용할 수 있을 시
                if (ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    // 위치 획득
                    val providerClient = LocationServices.getFusedLocationProviderClient(this@MainActivity)
                    providerClient.lastLocation.addOnSuccessListener(this@MainActivity, OnSuccessListener<Location> { location ->
                        val latitude = location?.latitude
                        val longitude = location?.longitude
                    })
                } else {
                    ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), requestLocationCode)
                }
            }

            override fun onConnectionSuspended(p0: Int) {
                // 위치 제공자를 사용 할 수 없을때
            }
        }
        val onConnectionFailedCallback = object : OnConnectionFailedListener {
            override fun onConnectionFailed(p0: ConnectionResult) {
                // 사용할 수 있는 위치 제공자가 없을때
            }
        }

        apiClient = GoogleApiClient.Builder(this@MainActivity)
            .addApi(LocationServices.API)
            .addConnectionCallbacks(connectionCallback)
            .addOnConnectionFailedListener(onConnectionFailedCallback)
            .build()

        // 위치 제공자 요청
        apiClient.connect()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == requestLocationCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // If permission granted, reconnect GoogleApiClient
                apiClient.reconnect()
            }
        }
    }

}
