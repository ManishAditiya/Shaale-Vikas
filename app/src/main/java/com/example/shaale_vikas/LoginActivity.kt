package com.example.shaale_vikas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.btnAdmin).setOnClickListener {
            val intent = Intent(this, HeadmasterLoginActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnDonor).setOnClickListener {
            val intent = Intent(this, DonorLoginActivity::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.tvRegister).setOnClickListener {
            Toast.makeText(this, "Registration feature coming soon!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun startMainActivity(role: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("ROLE", role)
        startActivity(intent)
        finish()
    }
}