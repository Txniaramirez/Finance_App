package com.example.finanzas_app.data.database

import androidx.room.TypeConverters
import com.example.finanzas_app.data.model.ExpenseCategory

class Converters {

    @TypeConverters
    fun fromExpenseCategory(category: ExpenseCategory): String{
        return category.name
    }

    @TypeConverters
    fun toExpenseCategory(value: String): ExpenseCategory{
        return ExpenseCategory.valueOf(value)
    }
}