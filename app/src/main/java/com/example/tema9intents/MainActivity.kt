package com.example.tema9intents

import android.app.SearchManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.view.Menu
import android.view.MenuItem
import com.example.tema9intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupIntents()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.actionSend) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else if (item.itemId == R.id.action2) {
            val intent = Intent(this, LlamarTelefono::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
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