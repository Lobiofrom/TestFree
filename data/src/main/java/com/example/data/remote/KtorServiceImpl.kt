package com.example.data.remote

import com.example.domain.ktorservice.KtorService
import com.example.domain.model.Response
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

class KtorServiceImpl(
    private val client: HttpClient
) : KtorService {
    override suspend fun getPosts(): Response {
        return client.get {
            url(HttpRoutes.BASE_URL)
            parameter("locale", "en-US")
            parameter("limit", 10)
        }
    }
}