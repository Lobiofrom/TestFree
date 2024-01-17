package com.example.domain.usecase

import com.example.domain.ktorservice.KtorService
import com.example.domain.model.Item

class GetPostsUseCase(
    private val ktorService: KtorService
) {
    suspend fun execute(): List<Item> {
        return ktorService.getPosts().result.list
    }
}