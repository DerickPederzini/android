package com.example.geradordesenhas_activity

import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geradordesenhas_activity.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding
    private var tamanho = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfirmar.setOnClickListener{
            val nextScreen = Intent(this, ThirdActivity::class.java).apply {
                putExtra(ThirdActivity.EXTRA_TAMANHO_SENHA, tamanho)
            }
            nextScreen.putExtra("tamanhoSenha", tamanho)
            startActivity(nextScreen)
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tamanho = progress.coerceAtLeast(4)
                binding.tvTamanho.text = "Tamanho da senha: $tamanho"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }
}