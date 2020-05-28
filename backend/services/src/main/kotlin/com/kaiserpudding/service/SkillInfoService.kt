package com.kaiserpudding.service

import com.kaiserpudding.model.SkillInfo

interface SkillInfoService {
    suspend fun getAll(): List<SkillInfo>

    suspend fun getByRole(role: String): List<SkillInfo>
}