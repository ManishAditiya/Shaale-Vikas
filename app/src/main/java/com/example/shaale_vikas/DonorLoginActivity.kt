package com.example.shaale_vikas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DonorLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_login)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLoginSubmit)
        val btnBack = findViewById<View>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            val isValid = when {
                username == "User1" && password == "User1@123" -> true
                username == "User2" && password == "User2@123" -> true
                username == "User3" && password == "User3@123" -> true
                else -> false
            }

            if (isValid) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("ROLE", "donor")
                startActivity(intent)
                finishAffinity()
            } else {
                Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}