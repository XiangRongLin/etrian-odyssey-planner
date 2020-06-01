package com.kaiserpudding.service

import com.kaiserpudding.service.demo.ServiceLocatorDemo
import com.kaiserpudding.service.implementation.ServiceLocatorImpl

interface ServiceLocator {
    val characterService: CharacterService
    val partyService: PartyService
    val roleService: RoleService
    val skillInfoService: SkillInfoService
    val skillService: SkillService
    val userService: UserService

    companion object {
        fun getDemoServiceLocator(): ServiceLocator {
            return ServiceLocatorDemo()
        }
        fun getImplServiceLocator(): ServiceLocator {
            return ServiceLocatorImpl()
        }
    }
}

