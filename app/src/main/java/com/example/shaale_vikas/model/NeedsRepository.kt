package com.example.shaale_vikas.model

object NeedsRepository {
    private val needsList = mutableListOf(
        Need("Toilet Repair", 15000.0, 9000.0),
        Need("Classroom Painting", 8000.0, 3200.0),
        Need("New Benches", 20000.0, 15000.0),
        Need("Library Books", 5000.0, 2500.0)
    )

    fun getNeeds(): List<Need> = needsList

    fun addNeed(need: Need) {
        needsList.add(need)
    }

    fun deleteNeed(need: Need) {
        needsList.remove(need)
    }

    fun updateNeedAmount(title: String, newTotal: Double) {
        needsList.find { it.title == title }?.totalAmount = newTotal
    }

    fun getNeedByTitle(title: String): Need? {
        return needsList.find { it.title == title }
    }

    fun pledgeDonation(title: String, amount: Double) {
        needsList.find { it.title == title }?.let {
            it.collectedAmount += amount
        }
    }
}