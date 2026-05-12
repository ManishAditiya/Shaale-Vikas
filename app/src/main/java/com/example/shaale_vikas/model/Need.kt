package com.example.shaale_vikas.model

data class Need(
    val title: String,
    var totalAmount: Double,
    var collectedAmount: Double,
    val beforePhoto: Int? = null,
    val afterPhoto: Int? = null,
    val isCompleted: Boolean = false
) {
    val progress: Int
        get() = if (totalAmount > 0) ((collectedAmount / totalAmount) * 100).toInt() else 0
        
    val amountString: String
        get() = "₹%,.0f Needed".format(totalAmount)
}