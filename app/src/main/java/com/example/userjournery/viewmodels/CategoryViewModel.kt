package com.example.userjournery.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userjournery.database.dao.CategoryDao
import com.example.userjournery.model.UserCategory
import com.example.userjournery.network.AppService
import com.example.userjournery.repositories.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel: ViewModel() {

    private var categoriesLiveData = MutableLiveData<List<UserCategory>>()

    fun getCategoriesLiveData(): MutableLiveData<List<UserCategory>> {
        return categoriesLiveData
    }

    fun fetchUserCategories(appService: AppService, categoryDao: CategoryDao) {
        viewModelScope.launch(Dispatchers.IO) {
            val categories = CategoryRepository().fetchUserCategories(viewModelScope, appService, categoryDao)
            categoriesLiveData.postValue(categories)
        }
    }
}