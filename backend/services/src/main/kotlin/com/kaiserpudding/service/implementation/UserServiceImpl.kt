package com.kaiserpudding.service.implementation

import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.repository.UserRepository
import com.kaiserpudding.service.UserService

class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override suspend fun create(jwtId: String): Int = dbQuery {
        userRepository.create(jwtId)
    }
}