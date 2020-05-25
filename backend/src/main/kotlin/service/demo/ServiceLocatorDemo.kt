package com.kaiserpudding.service.demo

import com.kaiserpudding.service.CharacterService
import com.kaiserpudding.service.PartyService
import com.kaiserpudding.service.RoleService
import com.kaiserpudding.service.ServiceLocator
import com.kaiserpudding.service.SkillInfoService
import com.kaiserpudding.service.SkillService

internal object ServiceLocatorDemo : ServiceLocator {
    override val characterService: CharacterService = CharacterServiceDemo()
    override val partyService: PartyService = PartyServiceDemo()
    override val roleService: RoleService = RoleServiceDemo()
    override val skillInfoService: SkillInfoService = SkillInfoServiceDemo()
    override val skillService: SkillService = SkillServiceDemo()
}