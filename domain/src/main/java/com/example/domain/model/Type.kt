package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Type(
    val key: String,
    val title: String
)