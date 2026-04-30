package com.example.finanzas_app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.finanzas_app.data.model.User
import kotlinx.coroutines.flow.Flow

/**
 * UserDao - Data Acces Object para la tabla Users
 **/

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User): Long

    @Query("SELECT * FROM users WHERE email= :email LIMIT 1")
    suspend fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM users WHERE id= :userId")
    fun getUserById(userId: Long): Flow<User?>

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)
}