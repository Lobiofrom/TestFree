package com.example.data.remote

import com.example.domain.ktorservice.KtorService
import com.example.domain.model.Response
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KtorServiceImpl(
    private val client: HttpClient
) : KtorService {
    override suspend fun getPosts(): Response {
        return withContext(Dispatchers.IO) {
            client.get {
                url(HttpRoutes.BASE_URL)
                parameter("locale", "en-US")
                parameter("limit", 10)
            }
        }
    }
}