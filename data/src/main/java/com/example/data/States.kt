package com.example.data

import com.example.domain.model.Item

sealed class States {
    data object Error : States()
    data object Loading : States()
    data class Success(val list: List<Item>) : States()
}