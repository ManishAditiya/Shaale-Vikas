package com.example.shaale_vikas

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class HallOfFameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hall_of_fame)

        findViewById<View>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}