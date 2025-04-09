package com.DerickPederzini.placar

import android.content.Intent
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

        handleFinishMatch()
        setUpExtras(savedInstanceState)
        handleScore()

    }

    private fun setUpExtras(savedInstanceState: Bundle?){
        binding.tvPlayer1.text = intent.getStringExtra("PLAYER1")
        binding.tvPlayer2.text = intent.getStringExtra("PLAYER2")

        if (savedInstanceState != null){
            playerOneScore = savedInstanceState.getInt("PLAYER_ONE_SCORE")
            playerTwoScore = savedInstanceState.getInt("PLAYER_TWO_SCORE")
            binding.tvPlayer1Name.text = playerOneScore.toString()
            binding.tvPlayer2Name.text = playerTwoScore.toString()
        }
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

    private fun handleFinishMatch(){
        binding.btTerminar.setOnClickListener{
            val ret = Intent()
            ret.putExtra(KEY_RESULT_EXTRA_PLAYER_ONE_NAME, binding.tvPlayer1.text.toString())
            ret.putExtra(KEY_RESULT_EXTRA_PLAYER_TWO_NAME, binding.tvPlayer2.text.toString())

            ret.putExtra(KEY_RESULT_EXTRA_PLAYER_ONE_SCORE, binding.tvPlayer1Name.text.toString().toInt())
            ret.putExtra(KEY_RESULT_EXTRA_PLAYER_TWO_SCORE, binding.tvPlayer2Name.text.toString().toInt())

            setResult(RESULT_OK, ret)
            super.finish()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("PLAYER_ONE_SCORE", playerOneScore)
        outState.putInt("PLAYER_TWO_SCORE", playerTwoScore)
    }
}