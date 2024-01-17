package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val list: List<Item>,
    val total: Int
)