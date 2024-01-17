package com.example.domain.ktorservice

import com.example.domain.model.Response

interface KtorService {
    suspend fun getPosts(): Response
}