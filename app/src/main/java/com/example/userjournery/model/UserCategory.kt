package com.example.userjournery.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * user categories data model
 * id - unique identifier of the category
 * name - name of the category
 */
@Entity(tableName = "user_category")
data class UserCategory(@PrimaryKey val id: Int, val name: String)
