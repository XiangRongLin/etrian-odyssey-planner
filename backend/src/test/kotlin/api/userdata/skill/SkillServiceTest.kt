package api.userdata.skill

import com.kaiserpudding.api.clearUserData
import com.kaiserpudding.api.dbTest
import com.kaiserpudding.api.getService
import com.kaiserpudding.api.initDatabase
import com.kaiserpudding.api.initUserData
import com.kaiserpudding.api.userdata.skill.SkillService
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SkillServiceTest {

    private val service = getService(SkillService::class.java)

    init {
        initDatabase()
    }


    @BeforeEach
    fun setUp() {
        initUserData()
    }

    @AfterEach
    fun tearDown() {
        clearUserData()
    }

    @Test
    fun `get skill from invalid character`() = dbTest {
        val result = service.getFromCharacter(-1)
        assertTrue(result.isEmpty())
    }

    @Test
    fun `get single skill of character`() = dbTest {
        val result = service.getFromCharacter(1)

        assertFalse(result.isEmpty())
        assertEquals(1, result.size)
        assertEquals(2, result.first().skillInfoId)
        assertEquals(2, result.first().level)
    }
}