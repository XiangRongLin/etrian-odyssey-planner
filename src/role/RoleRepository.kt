package com.kaiserpudding.role

import com.kaiserpudding.model.Role

object RoleRepository {
    lateinit var classes: List<Role>

    suspend fun getAll() : List<Role>{
        return if (RoleRepository::classes.isInitialized) {
            classes
        } else {
            RoleService().getAll()
        }
    }
}