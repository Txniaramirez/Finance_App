package com.example.finanzas_app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.finanzas_app.data.model.SharedExpense
import kotlinx.coroutines.flow.Flow


@Dao
interface SharedExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sharedExpense: SharedExpense)

    @Query("SELECT * FROM shared_expenses WHERE creatorUserId= :creatorUserId ORDER BY date DESC")
    fun getSharedExpensesByUser(creatorUserId: Long): Flow<List<SharedExpense>>

    @Query("SELECT * FROM shared_expenses WHERE creatorUserId= :creatorUserId AND settled = 0")
    fun getUnsettledSharedExpenses(creatorUserId: Long): Flow<List<SharedExpense>>

    @Update
    suspend fun update(sharedExpense: SharedExpense)

    @Delete
    suspend fun delete(sharedExpense: SharedExpense)
}