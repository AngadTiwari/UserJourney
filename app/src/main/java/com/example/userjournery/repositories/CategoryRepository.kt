package com.example.userjournery.repositories

import com.example.userjournery.database.dao.CategoryDao
import com.example.userjournery.model.UserCategory
import com.example.userjournery.network.AppService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class CategoryRepository {

    suspend fun fetchUserCategories(coroutineScope: CoroutineScope, appService: AppService, categoryDao: CategoryDao): List<UserCategory> {
        return coroutineScope.async(Dispatchers.IO) {
            if(true) { //check if network is available
                val categoriesResponse = appService.getUserCategories()
                if(categoriesResponse.isSuccessful && categoriesResponse.body() != null
                    && categoriesResponse.body()!!.isNotEmpty()) {
                    categoryDao.insertUserCategories(categoriesResponse.body()!!)
                    return@async categoriesResponse.body()!!
                } else {
                    return@async listOf()
                }
            } else {
                return@async categoryDao.getAllUserCategories()
            }
        }.await()
    }
}