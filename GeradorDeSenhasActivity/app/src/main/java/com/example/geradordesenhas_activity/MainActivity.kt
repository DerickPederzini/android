package com.example.geradordesenhas_activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geradordesenhas_activity.databinding.ActivityMainBinding
import com.example.geradordesenhas_activity.databinding.ActivityThirdBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnComecar.setOnClickListener{
            val nextScreen = Intent(this, SecondActivity::class.java)
            startActivity(nextScreen)
        }
    }

}