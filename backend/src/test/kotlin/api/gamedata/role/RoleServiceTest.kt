package api.gamedata.role

import com.kaiserpudding.api.dbTest
import com.kaiserpudding.api.gamedata.role.Role
import com.kaiserpudding.api.gamedata.role.RoleService
import com.kaiserpudding.api.getService
import com.kaiserpudding.api.initDatabase
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.Assert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RoleServiceTest {

    private val service = getService(RoleService::class.java)

    init {
        initDatabase()
    }

    @Test
    fun getAllRoles() = dbTest {
        val result = service.getAll()
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
        assertThat(result, containsInAnyOrder(*expected))
    }
}