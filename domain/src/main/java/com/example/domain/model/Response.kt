package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val result: Result,
    val retCode: Int,
    val retExtInfo: RetExtInfo,
    val retMsg: String,
    val time: Long
)