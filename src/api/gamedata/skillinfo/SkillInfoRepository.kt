package com.kaiserpudding.api.gamedata.skillinfo

import com.kaiserpudding.model.SkillInfo

object SkillInfoRepository {

    val service: SkillInfoService by lazy { SkillInfoService() }

    suspend fun getAll(): List<SkillInfo> {
        return service.getAll()
    }

    suspend fun get(id: Int): SkillInfo? {
        return service.get(id)
    }
}
