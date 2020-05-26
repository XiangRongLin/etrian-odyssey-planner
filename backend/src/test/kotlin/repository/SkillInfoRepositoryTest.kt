package com.kaiserpudding.repository

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class SkillInfoRepositoryTest : AbstractRepositoryTest() {

    private val repository = SkillInfoRepository()

    @Test
    fun getAll() = dbTest {
        val actual = repository.getAll()

        assertEquals(495, actual.size)
    }

    @Test
    fun getByRoleHero() = dbTest {
        val actual = repository.getByRole("Hero")

        assertEquals(26, actual.filter { it.role.name == "Hero" }.size)
    }

    @Test
    fun getByRoleMedic() = dbTest {
        val actual = repository.getByRole("Medic")

        assertEquals(26, actual.filter { it.role.name == "Medic" }.size)
    }

}
