package com.DerickPederzini.placar

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.DerickPederzini.placar.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private val DUR_SPLASH_MILLIS = 2000L
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val nextScreen = Intent(this, PlayerActivity::class.java)
            startActivity(nextScreen)
            finish()
        }, DUR_SPLASH_MILLIS)

    }
}