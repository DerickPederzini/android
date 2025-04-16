package com.example.geradordesenhas_activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geradordesenhas_activity.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tamanhoSenha = intent.getIntExtra(EXTRA_TAMANHO_SENHA, 4)
        binding.tvSenha.text = gerarSenha(tamanhoSenha)


    }

    private fun gerarSenha(tamanhoSenha: Int): String {
        val chars =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#\$%&*"
        return (1..tamanhoSenha).map { chars.random() }.joinToString("")
    }

    companion object{
        const val EXTRA_TAMANHO_SENHA = "EXTRA_TAMANHO_SENHA"
    }

}