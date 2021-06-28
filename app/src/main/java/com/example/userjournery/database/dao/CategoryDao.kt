package com.example.userjournery.database.dao

import androidx.room.*
import com.example.userjournery.model.UserCategory

@Dao
interface CategoryDao {

    @Query("select * from user_category")
    fun getAllUserCategories(): List<UserCategory>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUserCategories(userCategories: List<UserCategory>)
}