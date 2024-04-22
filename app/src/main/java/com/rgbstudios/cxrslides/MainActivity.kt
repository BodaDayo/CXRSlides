package com.rgbstudios.cxrslides

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rgbstudios.cxrslides.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setup view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Launch the StudyActivity on studyBtn click
        binding.studyBtn.setOnClickListener {
            listIntent = Intent(this, StudyActivity::class.java)
            startActivity(listIntent)
        }

        // Launch the TestActivity on testBtn click
        binding.testBtn.setOnClickListener {
            listIntent = Intent(this, TestActivity::class.java)
            startActivity(listIntent)
        }
    }

}