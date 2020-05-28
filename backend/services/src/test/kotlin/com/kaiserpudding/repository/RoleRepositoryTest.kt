package com.kaiserpudding.repository

import com.kaiserpudding.model.Role
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class RoleRepositoryTest : AbstractRepositoryTest() {

    private val repository = RoleRepository()

    @Test
    fun getAll() = dbTest {
        val actual = repository.getAll()
        val expected = listOf(
            "Protector",
            "Survivalist",
            "Medic",
            "Ronin",
            "War Magus",
            "Gunner",
            "Zodiac",
            "Farmer",
            "Ninja",
            "Sovereign",
            "Shogun",
            "Nightseeker",
            "Landsknecht",
            "Arcanist",
            "Imperial",
            "Highlander",
            "Harbinger",
            "Pugilist",
            "Hero",
            "Vampire"
        ).map { Role(it) }
            .toTypedArray()

        // * operator https://kotlinlang.org/docs/reference/functions.html#variable-number-of-arguments-varargs
        assertThat(actual, containsInAnyOrder(*expected))
    }
}