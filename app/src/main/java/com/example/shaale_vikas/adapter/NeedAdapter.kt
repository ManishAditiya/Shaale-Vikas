package com.example.shaale_vikas.adapter

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shaale_vikas.NeedDetailsActivity
import com.example.shaale_vikas.R
import com.example.shaale_vikas.model.Need
import com.example.shaale_vikas.model.NeedsRepository

class NeedAdapter(
    private val list: List<Need>, 
    private val role: String,
    private val onDataChanged: () -> Unit
) : RecyclerView.Adapter<NeedAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.txtTitle)
        val amount: TextView = view.findViewById(R.id.txtAmount)
        val progressBar: ProgressBar = view.findViewById(R.id.progressBar)
        val progressText: TextView = view.findViewById(R.id.txtProgress)
        val button: Button = view.findViewById(R.id.btnPledge)
        val layoutManage: View = view.findViewById(R.id.layoutManage)
        val btnEdit: ImageView = view.findViewById(R.id.btnEdit)
        val btnDelete: ImageView = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_need, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.title.text = item.title
        holder.amount.text = item.amountString
        holder.progressBar.progress = item.progress
        holder.progressText.text = "${item.progress}% Collected"

        // Handle Role Visibility
        if (role == "admin") {
            holder.layoutManage.visibility = View.VISIBLE
            holder.button.visibility = View.GONE
        } else {
            holder.layoutManage.visibility = View.GONE
            holder.button.visibility = View.VISIBLE
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, NeedDetailsActivity::class.java)
            intent.putExtra("NEED_TITLE", item.title)
            holder.itemView.context.startActivity(intent)
        }

        holder.button.setOnClickListener {
            showPledgeDialog(holder.itemView, item)
        }

        holder.btnEdit.setOnClickListener {
            showEditDialog(holder.itemView, item)
        }

        holder.btnDelete.setOnClickListener {
            showDeleteConfirmation(holder.itemView, item)
        }
    }

    private fun showPledgeDialog(view: View, need: Need) {
        val builder = AlertDialog.Builder(view.context)
        builder.setTitle("Pledge Support for ${need.title}")
        
        val input = EditText(view.context)
        input.hint = "Enter amount to donate (e.g. 500)"
        input.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        builder.setView(input)

        builder.setPositiveButton("Confirm Donation") { _, _ ->
            val donationAmt = input.text.toString().toDoubleOrNull()
            if (donationAmt != null && donationAmt > 0) {
                NeedsRepository.pledgeDonation(need.title, donationAmt)
                onDataChanged()
                Toast.makeText(view.context, "Thank you for your generous support!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(view.context, "Please enter a valid amount", Toast.LENGTH_SHORT).show()
            }
        }
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }

    private fun showEditDialog(view: View, need: Need) {
        val builder = AlertDialog.Builder(view.context)
        builder.setTitle("Edit Amount for ${need.title}")
        
        val input = EditText(view.context)
        input.hint = "Enter new total amount"
        input.setText(need.totalAmount.toInt().toString())
        builder.setView(input)

        builder.setPositiveButton("Update") { _, _ ->
            val newAmt = input.text.toString().toDoubleOrNull()
            if (newAmt != null) {
                NeedsRepository.updateNeedAmount(need.title, newAmt)
                onDataChanged()
                Toast.makeText(view.context, "Amount updated!", Toast.LENGTH_SHORT).show()
            }
        }
        builder.setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }
        builder.show()
    }

    private fun showDeleteConfirmation(view: View, need: Need) {
        AlertDialog.Builder(view.context)
            .setTitle("Delete Need")
            .setMessage("Are you sure you want to delete ${need.title}?")
            .setPositiveButton("Delete") { _, _ ->
                NeedsRepository.deleteNeed(need)
                onDataChanged()
                Toast.makeText(view.context, "Need deleted", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}