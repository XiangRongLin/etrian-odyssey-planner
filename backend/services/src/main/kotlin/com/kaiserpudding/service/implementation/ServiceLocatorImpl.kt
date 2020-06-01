package com.kaiserpudding.service.implementation

import com.kaiserpudding.repository.*
import com.kaiserpudding.service.*

internal class ServiceLocatorImpl : ServiceLocator {
    override val characterService: CharacterService = CharacterServiceImpl(CharacterRepository(), UserRepository())
    override val partyService: PartyService = PartyServiceImpl(PartyRepository(), UserRepository())
    override val roleService: RoleService = RoleServiceImpl(RoleRepository())
    override val skillInfoService: SkillInfoService = SkillInfoServiceImpl(SkillInfoRepository())
    override val skillService: SkillService = SkillServiceImpl(SkillRepository(), UserRepository())
    override val userService: UserService = UserServiceImpl(UserRepository())
}