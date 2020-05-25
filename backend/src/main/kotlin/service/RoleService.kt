package com.kaiserpudding.service

import com.kaiserpudding.model.Role

interface RoleService {
    suspend fun getAll(): List<Role>
}