package com.kaiserpudding.database.init.src

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.util.escapeHTML
import java.nio.file.Files
import java.nio.file.Paths

//"([^\"a-zA-Z_])([a-zA-Z_]+):"
fun main() {
    val reader = Files.newBufferedReader(Paths.get("src/database/init/skills.json"))
    val mapper = ObjectMapper()
    val root: JsonNode = mapper.readTree(reader)

    val writer = Files.newBufferedWriter(Paths.get("resources/sql/skills.sql"))
    val skillMap = mutableMapOf<String, Int>()
    var idCounter = 0
    val skillInfoSql = mutableListOf<String>()
    val skillInfoPrerequisiteSql = mutableListOf<String>()
    root.fieldNames().forEach { roleName ->
        val skills = root[roleName]
        skills.fieldNames().forEach { skillNameShort ->
            val skillNode = skills[skillNameShort]
            skillMap[skillNameShort] = idCounter
            skillInfoSql += generateSkillInfoSQL(
                idCounter,
                roleName,
                skillNode["name_en"].textValue(),
                skillNode["desc"].textValue(),
                skillNode["maxLevel"].intValue()
            )
            idCounter++
        }
    }

    root.fieldNames().forEach { roleName ->
        val skills = root[roleName]
        skills.fieldNames().forEach { skillName ->
            val skillNode = skills[skillName]
            val prerequisiteNodes = skillNode["dep"]
            skillNode["dep"].fieldNames().forEach { prerequisiteName ->
                val prerequisiteNode = prerequisiteNodes[prerequisiteName]
                skillInfoPrerequisiteSql += generateSkillInfoPrerequesiteSQL(
                    skillMap[skillName]!!,
                    skillMap[prerequisiteName]!!,
                    prerequisiteNode.intValue()
                )

            }
        }
    }

    skillInfoSql.forEach {
        writer.append(it)
        writer.newLine()
    }
    skillInfoPrerequisiteSql.forEach {
        writer.append(it)
        writer.newLine()
    }
    writer.flush()
    writer.close()
}

fun generateSkillInfoSQL(id: Int, roleName: String, name: String, description: String, maxLevel: Int): String {
    description.escapeHTML()
    return "INSERT INTO skill_infos (id, role_name, name, description, max_level) " +
            "VALUES ($id, '${roleName.escapeSingleQuote()}', '${name.escapeSingleQuote()}', '${description.escapeSingleQuote()}', $maxLevel);"
}

fun generateSkillInfoPrerequesiteSQL(skillInfoId: Int, prerequisiteId: Int, prerequisiteLevel: Int): String {
    return "Insert INTO skill_info_prerequisites (skill_info_id, prerequisite_id, prerequisite_level) " +
            "VALUES ($skillInfoId, $prerequisiteId, $prerequisiteLevel);"
}

private fun String.escapeSingleQuote(): String {
    return this.replace("'", "''")
}