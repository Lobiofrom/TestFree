package com.example.freecustomer.di

import com.example.domain.ktorservice.KtorService
import com.example.data.remote.KtorServiceImpl
import com.example.domain.usecase.GetPostsUseCase
import com.example.freecustomer.viewmodel.MyViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {
    single {
        HttpClient(Android) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }
    }
    single<KtorService> { KtorServiceImpl(get()) }
    factory { GetPostsUseCase(get()) }
    viewModel { MyViewModel(get()) }
}