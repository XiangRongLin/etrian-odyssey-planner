package com.kaiserpudding.repository

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class UserRepositoryTest : AbstractRepositoryTest() {

    private val repository = UserRepository()

    @Test
    fun createAndGet() = dbTest {
        val userId = repository.create()
        val actual = repository.get(userId)

        assertTrue(actual != null)
        assertEquals(userId, actual!!.id)
    }
}