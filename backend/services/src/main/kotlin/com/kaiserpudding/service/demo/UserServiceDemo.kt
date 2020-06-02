package com.kaiserpudding.service.demo

import com.kaiserpudding.service.UserService

class UserServiceDemo : UserService {
    override suspend fun create(jwtSubject: String): Int {
        TODO("Not yet implemented")
    }
}