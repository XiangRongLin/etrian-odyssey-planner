package com.kaiserpudding.service.implementation

import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.model.Role
import com.kaiserpudding.repository.RoleRepository
import com.kaiserpudding.service.RoleService

internal class RoleServiceImpl(private val roleRepository: RoleRepository) : RoleService {
    override suspend fun getAll(): List<Role> = dbQuery {
        roleRepository.getAll()
    }
}