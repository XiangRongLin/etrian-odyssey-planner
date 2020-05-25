package com.kaiserpudding.service.demo

import com.kaiserpudding.model.SkillInfo
import com.kaiserpudding.service.SkillInfoService

internal class SkillInfoServiceDemo : SkillInfoService {
    override suspend fun getAll(): List<SkillInfo> {
        TODO("Not yet implemented")
    }

    override suspend fun getByRole(role: String): List<SkillInfo> {
        TODO("Not yet implemented")
    }
}