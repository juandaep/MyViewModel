package com.example.myviewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.internal.runners.statements.ExpectException
import org.junit.rules.ExpectedException
import java.lang.NumberFormatException

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel

    @get: Rule
    var thrown = ExpectedException.none()

    @Before
    fun init() {
        mainViewModel = MainViewModel()
    }

    @Test
    @Throws(NumberFormatException::class)
    fun calculate() {
        val width = "1"
        val length = "2.4"
        val height = "3"
        //tambahkan jika string berisi double bukan integer
        thrown.expect(NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"2.4\"")
        mainViewModel.calculate(width, length, height)
        assertEquals(6, mainViewModel.result)
    }

    @Test
    @Throws(NumberFormatException::class)
    fun emptyInputCalculateTest() {
        val width = "1"
        val length = ""
        val height = "3"
        //tambahkan jika string berisi double bukan integer
        thrown.expect(NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"\"")
        mainViewModel.calculate(width, length, height)
    }
}