package com.kaiserpudding.service

interface UserService {
    suspend fun create(jwtId: String): Int
}