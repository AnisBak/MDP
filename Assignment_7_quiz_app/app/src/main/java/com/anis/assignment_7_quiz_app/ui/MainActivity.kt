package com.anis.assignment_7_quiz_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anis.assignment_7_quiz_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var result: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}