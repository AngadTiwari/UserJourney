package com.example.userjournery.ui.cateogry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.userjournery.R
import com.example.userjournery.constants.AppDatabaseConstants
import com.example.userjournery.database.AppDatabase
import com.example.userjournery.databinding.ActivityCategoryBinding
import com.example.userjournery.network.AppService
import com.example.userjournery.viewmodels.CategoryViewModel

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding
    private lateinit var userCategoryAdapter: CategoryRecyclerAdapter
    private val categoryViewModel: CategoryViewModel by viewModels<CategoryViewModel>()
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUserCategoryRecycler()
        fetchUserCategories()
    }

    /**
     * initialize the user category recycler adapter
     */
    private fun initUserCategoryRecycler() {
        userCategoryAdapter = CategoryRecyclerAdapter()
        binding.recyclerUserCategory.adapter = userCategoryAdapter
    }

    /**
     * fetch the users categories
     */
    private fun fetchUserCategories() {
        categoryViewModel.getCategoriesLiveData().observe(this, { categories ->
            userCategoryAdapter.swapData(categories)
        })
        database = Room.databaseBuilder(this, AppDatabase::class.java, AppDatabaseConstants.DB_NAME)
            .build()
        categoryViewModel.fetchUserCategories(AppService.getAppService(), database.categoryDao())
    }
}