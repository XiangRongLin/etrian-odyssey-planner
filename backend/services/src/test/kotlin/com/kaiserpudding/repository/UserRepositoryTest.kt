package com.kaiserpudding.repository

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class UserRepositoryTest : AbstractRepositoryTest() {

    private val repository = UserRepository()

    @Test
    fun createAndGet() = dbTest {
        val userId = repository.create("jwt2")
        val actual = repository.get(userId)

        assertTrue(actual != null)
        assertEquals(userId, actual!!.id)
    }

    @Test
    fun `get(), non-existent`() = dbTest {
        val actual = repository.get(-1)

        assertTrue(actual == null)
    }

    @Test
    fun resolveId() = dbTest {
        val actual = repository.resolveId("jwt")

        assertEquals(user.id, actual)
    }

    @Test
    fun `resolveId(), non-existent`() = dbTest {
        assertThrows<NoSuchElementException> {
            repository.resolveId("abcdefg")
        }
    }
}