package com.bulfa.activity5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bulfa.activity5.databinding.ActivityPermissionResultBinding

class PermissionResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPermissionResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPermissionResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resultTextView.text = intent.getStringExtra("getPermission")

        binding.backButton.setOnClickListener {
            finish()
        }

    }
}