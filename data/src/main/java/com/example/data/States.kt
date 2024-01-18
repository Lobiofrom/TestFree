package com.example.data

import com.example.domain.model.Item

sealed class States {
    data class Error(val error: String?) : States()
    data object Loading : States()
    data class Success(val list: List<Item>) : States()
}