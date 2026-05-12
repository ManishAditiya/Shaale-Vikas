package com.example.shaale_vikas

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.shaale_vikas.model.NeedsRepository

class NeedDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_need_details)

        val title = intent.getStringExtra("NEED_TITLE") ?: ""
        val need = NeedsRepository.getNeedByTitle(title)

        findViewById<View>(R.id.btnBack).setOnClickListener {
            finish()
        }

        if (need != null) {
            findViewById<TextView>(R.id.tvTitleDetail).text = need.title
            findViewById<TextView>(R.id.tvPercentage).text = "${need.progress}%"
            findViewById<ProgressBar>(R.id.circularProgress).progress = need.progress
            
            findViewById<TextView>(R.id.tvCollectedAmt).text = "₹%,.0f".format(need.collectedAmount)
            findViewById<TextView>(R.id.tvRemainingAmt).text = "₹%,.0f".format(need.totalAmount - need.collectedAmount)
        }
    }
}