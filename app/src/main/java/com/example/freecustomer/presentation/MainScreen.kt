package com.example.freecustomer.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.data.States
import com.example.freecustomer.viewmodel.MyViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    viewModel: MyViewModel = koinViewModel(),
    modifier: Modifier
) {

    val state = viewModel.state.collectAsState()

    when (state.value) {
        States.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No connection")
            }
        }

        States.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is States.Success -> {
            val items = (state.value as States.Success).list
            LazyColumn(
                modifier = modifier
            ) {
                items(items) {
                    Success(item = it)
                }
            }
        }
    }
}