package com.example.shaale_vikas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HeadmasterLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_headmaster_login)

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

            if (username == "Headmaster" && password == "Headmaster@123") {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("ROLE", "admin")
                startActivity(intent)
                finishAffinity() // Clear activity stack
            } else {
                Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}