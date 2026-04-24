package com.example.finanzas_app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * User - Entidad que representa un usuario en la base de datos
 **/

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val email: String,
    val passwordHash: String,
    val createAt: Long = System.currentTimeMillis()
)
