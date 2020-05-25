package com.kaiserpudding.service.implementation

import com.kaiserpudding.repository.CharacterRepository
import com.kaiserpudding.repository.PartyRepository
import com.kaiserpudding.repository.RoleRepository
import com.kaiserpudding.repository.SkillInfoRepository
import com.kaiserpudding.repository.SkillRepository
import com.kaiserpudding.service.CharacterService
import com.kaiserpudding.service.PartyService
import com.kaiserpudding.service.RoleService
import com.kaiserpudding.service.ServiceLocator
import com.kaiserpudding.service.SkillInfoService

internal object ServiceLocatorImpl : ServiceLocator {
    override val characterService: CharacterService = CharacterServiceImpl(CharacterRepository(), SkillRepository())
    override val partyService: PartyService = PartyServiceImpl(PartyRepository())
    override val roleService: RoleService = RoleServiceImpl(RoleRepository())
    override val skillInfoService: SkillInfoService = SkillInfoServiceImpl(SkillInfoRepository())
}