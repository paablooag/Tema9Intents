package com.example.tema9intents

import android.app.SearchManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import com.example.tema9intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupIntents()
    }

    fun setupIntents(){

        binding.sendEmailButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:"+binding.tvWeb.text.toString())
            intent.putExtra(Intent.EXTRA_SUBJECT, "Onlyfans")
            intent.putExtra(Intent.EXTRA_TEXT, "Sentimos comunicarte que tu cuenta ha sido baneada por contenido inapropiado. No esta permitido subir contenido de este tipo de muertes a personas de la raza negra a nuestra plataforma.")
            startActivity(intent)
        }
    }
}