package com.kaiserpudding.repository

import com.kaiserpudding.model.NewSkill
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.jupiter.api.Test

internal class SkillRepositoryTest : AbstractRepositoryTest() {

    private val repository = SkillRepository()

    @Test
    fun `get skill from invalid character`() = dbTest {
        val result = repository.getByCharacter(-1)
        assertTrue(result.isEmpty())
    }

    @Test
    fun `get single skill of character`() = dbTest {
        val result = repository.getByCharacter(1)

        assertFalse(result.isEmpty())
        assertEquals(1, result.size)
        assertEquals(2, result.first().skillInfoId)
        assertEquals(2, result.first().level)
    }

    @Test
    fun `add skill`() = dbTest {
        repository.create(1, NewSkill(null, 3, 2))
        val result = repository.getByCharacter(1)

        assertFalse(result.isEmpty())
        assertEquals(2, result.size)
    }
}