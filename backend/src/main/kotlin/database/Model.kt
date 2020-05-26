package com.kaiserpudding.database

import com.kaiserpudding.model.Position
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object RoleTable : Table("roles") {
    val name = RoleTable.varchar("name", 15)
    override val primaryKey: PrimaryKey = PrimaryKey(name)
}

object SkillInfoTable : Table("skill_infos") {
    val id = SkillInfoTable.integer("id")
    val roleName = SkillInfoTable.varchar("role_name", 15).references(
        RoleTable.name,
        onUpdate = ReferenceOption.CASCADE,
        onDelete = ReferenceOption.RESTRICT
    )
    val name = SkillInfoTable.varchar("name", 30)
    val description = SkillInfoTable.varchar("description", 400)
    val maxLevel = SkillInfoTable.integer("max_level")
    override val primaryKey = PrimaryKey(id)
}

object SkillInfoPrerequisiteTable : Table("skill_info_prerequisites") {
    val skillInfoId = SkillInfoPrerequisiteTable.integer("skill_info_id").index().references(
        SkillInfoTable.id,
        onUpdate = ReferenceOption.CASCADE,
        onDelete = ReferenceOption.CASCADE
    )
    val prerequisiteId = SkillInfoPrerequisiteTable.integer("prerequisite_id")
        .references(
            SkillInfoTable.id,
            onUpdate = ReferenceOption.CASCADE,
            onDelete = ReferenceOption.CASCADE
        )
    val prerequisiteLevel = SkillInfoPrerequisiteTable.integer("prerequisite_level")

    init {
        SkillInfoPrerequisiteTable.uniqueIndex(skillInfoId, prerequisiteId)
    }
}

object CharacterTable : Table("characters") {
    val id = CharacterTable.integer("id").autoIncrement()
    val name = CharacterTable.varchar("name", 30)
    val role = CharacterTable.varchar("role", 15).references(
        RoleTable.name,
        onUpdate = ReferenceOption.CASCADE,
        onDelete = ReferenceOption.RESTRICT
    )
    override val primaryKey = PrimaryKey(id)

}

object PartyTable : Table("parties") {
    val id = PartyTable.integer("id").autoIncrement()
    val name = PartyTable.varchar("name", 20)
    override val primaryKey = PrimaryKey(id)

}

object PartyMemberTable : Table("party_members") {
    val partyId = PartyMemberTable.integer("party_id").index()
        .references(PartyTable.id, onUpdate = ReferenceOption.CASCADE, onDelete = ReferenceOption.CASCADE)
    val memberId = PartyMemberTable.integer("member_id")
        .references(CharacterTable.id, onUpdate = ReferenceOption.CASCADE, onDelete = ReferenceOption.CASCADE)
    val position = PartyMemberTable.enumerationByName("position", 15, Position::class)

    init {
        PartyMemberTable.uniqueIndex(partyId, memberId)
        PartyMemberTable.uniqueIndex(partyId, position)
    }
}

object SkillTable : Table("skills") {
    val skillInfoId = SkillTable.integer("skill_info_id").references(
        SkillInfoTable.id,
        onUpdate = ReferenceOption.CASCADE,
        onDelete = ReferenceOption.RESTRICT
    )
    val level = SkillTable.integer("level")
    val characterId = SkillTable.integer("character_id").references(
        CharacterTable.id,
        onUpdate = ReferenceOption.CASCADE,
        onDelete = ReferenceOption.CASCADE
    )

    init {
        SkillTable.uniqueIndex(skillInfoId, characterId)
    }
}