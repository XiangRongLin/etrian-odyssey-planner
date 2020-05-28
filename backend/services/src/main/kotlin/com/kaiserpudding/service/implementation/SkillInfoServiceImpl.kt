package com.kaiserpudding.service.implementation

import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.model.SkillInfo
import com.kaiserpudding.repository.SkillInfoRepository
import com.kaiserpudding.service.SkillInfoService


internal class SkillInfoServiceImpl(private val skillInfoRepository: SkillInfoRepository) : SkillInfoService {

    override suspend fun getAll(): List<SkillInfo> = dbQuery {
        skillInfoRepository.getAll()
    }

    override suspend fun getByRole(role: String): List<SkillInfo> = dbQuery {
        skillInfoRepository.getByRole(role)
    }
}