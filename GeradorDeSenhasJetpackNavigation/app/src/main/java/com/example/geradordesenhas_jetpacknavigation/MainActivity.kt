package com.example.geradordesenhas_jetpacknavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.geradordesenhas_jetpacknavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}