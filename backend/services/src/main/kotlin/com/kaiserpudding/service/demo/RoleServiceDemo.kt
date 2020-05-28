package com.kaiserpudding.service.demo

import com.kaiserpudding.model.Role
import com.kaiserpudding.service.RoleService

internal class RoleServiceDemo : RoleService {
    override suspend fun getAll(): List<Role> {
        TODO("Not yet implemented")
    }
}