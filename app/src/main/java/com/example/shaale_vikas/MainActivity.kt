package com.example.shaale_vikas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shaale_vikas.adapter.NeedAdapter
import com.example.shaale_vikas.model.NeedsRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tvNeedsCount: TextView
    private lateinit var role: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        role = intent.getStringExtra("ROLE") ?: "donor"
        
        val tvRole = findViewById<TextView>(R.id.tvRole)
        val fabAddNeed = findViewById<FloatingActionButton>(R.id.fabAddNeed)
        val btnLogout = findViewById<View>(R.id.btnLogout)
        val btnHallOfFame = findViewById<View>(R.id.btnHallOfFame)
        val btnBack = findViewById<View>(R.id.btnBack)
        
        recyclerView = findViewById(R.id.recyclerView)
        tvNeedsCount = findViewById(R.id.tvNeedsCount)

        btnBack.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        if (role == "admin") {
            tvRole.text = "Logged in as Headmaster"
            fabAddNeed.visibility = View.VISIBLE
        } else {
            tvRole.text = "Logged in as Donor / Alumni"
            fabAddNeed.visibility = View.GONE
        }

        btnHallOfFame.setOnClickListener {
            val intent = Intent(this, HallOfFameActivity::class.java)
            startActivity(intent)
        }

        btnLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        fabAddNeed.setOnClickListener {
            val intent = Intent(this, AddNeedActivity::class.java)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        refreshData()
    }

    override fun onResume() {
        super.onResume()
        refreshData()
    }

    private fun refreshData() {
        val list = NeedsRepository.getNeeds()
        recyclerView.adapter = NeedAdapter(list, role) {
            refreshData()
        }
        tvNeedsCount.text = list.size.toString()
    }
}