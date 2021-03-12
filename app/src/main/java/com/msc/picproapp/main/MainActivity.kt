package com.msc.picproapp.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.msc.picproapp.databinding.MainAcitivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainAcitivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainAcitivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}