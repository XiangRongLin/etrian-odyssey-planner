package com.kaiserpudding.service

interface ServiceLocator {
    val characterService: CharacterService
    val partyService: PartyService
    val roleService: RoleService
    val skillInfoService: SkillInfoService
    val skillService: SkillService
}

