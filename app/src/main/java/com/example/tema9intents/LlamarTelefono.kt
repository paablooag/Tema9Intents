package com.example.tema9intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.tema9intents.databinding.ActivityLlamarTelefonoBinding
import com.example.tema9intents.databinding.ActivityMainBinding

class LlamarTelefono : AppCompatActivity() {

    private lateinit var binding: ActivityLlamarTelefonoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLlamarTelefonoBinding.inflate(layoutInflater)
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

    private fun setupIntents() {
        binding.sendPhoneButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:"+binding.tvTelefono.text.toString())
            startActivity(intent)
        }
        binding.tvWeb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com")
            startActivity(intent)
        }
    }
}