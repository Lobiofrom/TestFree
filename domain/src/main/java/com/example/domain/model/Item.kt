package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val dateTimestamp: Long,
    val description: String,
    val endDateTimestamp: Long,
    val startDateTimestamp: Long,
    val tags: List<String>,
    val title: String,
    val type: Type,
    val url: String
)
