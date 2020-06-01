package com.kaiserpudding.service.demo

import com.kaiserpudding.service.*

internal class ServiceLocatorDemo : ServiceLocator {
    override val characterService: CharacterService = CharacterServiceDemo()
    override val partyService: PartyService = PartyServiceDemo()
    override val roleService: RoleService = RoleServiceDemo()
    override val skillInfoService: SkillInfoService = SkillInfoServiceDemo()
    override val skillService: SkillService = SkillServiceDemo()
    override val userService: UserService = UserServiceDemo()
}