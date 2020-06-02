package com.kaiserpudding.service

interface UserService {
    suspend fun create(jwtSubject: String): Int
}