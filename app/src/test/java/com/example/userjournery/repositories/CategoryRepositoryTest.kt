package com.example.userjournery.repositories

import com.example.userjournery.database.dao.CategoryDao
import com.example.userjournery.model.UserCategory
import com.example.userjournery.network.AppService
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineScope
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CategoryRepositoryTest {

    private lateinit var coroutineScope: TestCoroutineScope

    @Mock private lateinit var mockAppService: AppService
    @Mock private lateinit var mockCategoryDao: CategoryDao

    @Before
    fun setUp() {
        coroutineScope = TestCoroutineScope()
    }

    @Test
    fun categoryScreen_checkAllCategoryFetch_ResultNotNull() {
        coroutineScope.launch(Dispatchers.IO) {
            //Mockito.`when`(mockAppService.getUserCategories()).thenReturn(
                //listOf<UserCategory>(UserCategory(1, "Electronics"))
            //)
        }
    }
}