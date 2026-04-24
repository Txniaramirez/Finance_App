package com.example.finanzas_app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Expense - Entidad que representa un gasto en la base de datos
 **/

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userId: Long,
    val amount: Double,
    val category: ExpenseCategory,
    val description: String,
    val date: Long = System.currentTimeMillis(),
    val isRecurring: Boolean = false
)
