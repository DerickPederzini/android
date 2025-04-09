package com.DerickPederzini.placar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.DerickPederzini.placar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var playerOneScore = 0;
    private var playerTwoScore = 0;

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setUpExtras()
        handleScore()
    }

    private fun setUpExtras(){
        binding.tvPlayer1.text = intent.getStringExtra("PLAYER1")
        binding.tvPlayer2.text = intent.getStringExtra("PLAYER2")
    }

    private fun handleScore(){
        binding.btCasa.setOnClickListener{
            playerOneScore++
            binding.tvPlayer1Name.text = playerOneScore.toString()

        }
        binding.btVisitante.setOnClickListener{
            playerTwoScore++
            binding.tvPlayer2Name.text = playerTwoScore.toString()

        }
    }
}