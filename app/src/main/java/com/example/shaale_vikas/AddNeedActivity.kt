package com.example.shaale_vikas

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.shaale_vikas.model.Need
import com.example.shaale_vikas.model.NeedsRepository

class AddNeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_need)

        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etAmount = findViewById<EditText>(R.id.etAmount)
        val imgPreview = findViewById<ImageView>(R.id.imgPreviewBefore)
        val btnPick = findViewById<View>(R.id.btnPickBefore)
        val btnBack = findViewById<View>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }

        btnPick.setOnClickListener {
            // Simulate photo selection
            imgPreview.setPadding(0, 0, 0, 0)
            imgPreview.setImageResource(android.R.drawable.ic_menu_gallery)
            Toast.makeText(this, "Photo selected!", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            val title = etTitle.text.toString()
            val amountStr = etAmount.text.toString().replace("₹", "").replace(",", "")
            val amount = amountStr.toDoubleOrNull() ?: 0.0

            if (title.isNotEmpty() && amount > 0) {
                val newNeed = Need(
                    title = title,
                    totalAmount = amount,
                    collectedAmount = 0.0
                )
                NeedsRepository.addNeed(newNeed)
                Toast.makeText(this, "Need added successfully!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Please fill in valid details", Toast.LENGTH_SHORT).show()
            }
        }
    }
}