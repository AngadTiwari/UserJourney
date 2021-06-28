package com.example.userjournery.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.userjournery.constants.AppDatabaseConstants
import com.example.userjournery.database.dao.CategoryDao
import com.example.userjournery.model.UserCategory

@Database(entities = [UserCategory::class], version = AppDatabaseConstants.DB_VERSION)
abstract class AppDatabase: RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
}