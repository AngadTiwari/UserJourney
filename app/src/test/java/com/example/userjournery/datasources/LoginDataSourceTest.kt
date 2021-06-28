package com.example.userjournery.datasources

import com.example.userjournery.data.Result
import com.example.userjournery.model.LoggedInUser
import junit.framework.TestCase
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException
import java.lang.NullPointerException
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class LoginDataSourceTest {

    private lateinit var loginDataSource: LoginDataSource
    val fakeUser = LoggedInUser(UUID.randomUUID().toString(), "Jane Doe")

    @Before
    fun setUp() {
        loginDataSource = LoginDataSource()
    }

    @Test
    fun loginScreen_checkUsernameBlankValidation_ResultFalse() {
        Mockito.`when`(loginDataSource.login("", "Passwor@123")).thenReturn(Result.Error(IOException()))
        //assertThat() check expected and output type Result
    }
}