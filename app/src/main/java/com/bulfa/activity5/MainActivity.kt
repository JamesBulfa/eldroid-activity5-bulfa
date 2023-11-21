package com.bulfa.activity5

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.bulfa.activity5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.locationPermissionButton.setOnClickListener {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    Constants.LOCATION_PERMISSION_ACCESS_CODE
                )
            } else {
                val intent = Intent(this, PermissionResultActivity::class.java)
                intent.putExtra("getPermission", "Permission granted: ${Manifest.permission.ACCESS_FINE_LOCATION}")
                startActivity(intent)
            }
        }

        binding.cameraPermissionButton.setOnClickListener {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA),
                    Constants.CAMERA_PERMISSION_ACCESS_CODE
                )
            } else {
                val intent = Intent(this, PermissionResultActivity::class.java)
                intent.putExtra("getPermission", "Permission granted: ${Manifest.permission.CAMERA}")
                startActivity(intent)
            }
        }

        binding.audioPermissionButton.setOnClickListener {
            if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.RECORD_AUDIO),
                    Constants.AUDIO_PERMISSION_ACCESS_CODE
                )
            } else {
                val intent = Intent(this, PermissionResultActivity::class.java)
                intent.putExtra("getPermission", "Permission granted: ${Manifest.permission.RECORD_AUDIO}")
                startActivity(intent)
            }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission is granted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Permission is denied", Toast.LENGTH_SHORT).show()
        }
    }

}