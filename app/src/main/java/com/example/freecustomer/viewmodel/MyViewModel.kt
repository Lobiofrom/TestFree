package com.example.freecustomer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.States
import com.example.domain.usecase.GetPostsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyViewModel(
    private val useCase: GetPostsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<States>(States.Loading)
    val state = _state.asStateFlow()

    init {
        _state.value = States.Loading
        viewModelScope.launch {
            try {
                _state.value = States.Success(useCase.execute())
            } catch (e: Exception) {
                _state.value = States.Error(e.message)
            }
        }
    }
}