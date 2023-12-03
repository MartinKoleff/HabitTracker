package com.koleff.habittracker.ui.composable.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.koleff.habittracker.ui.composable.MainScreenScaffold

@Composable
fun SearchScreen(navController: NavHostController) {
    MainScreenScaffold("Search", navController) { innerPadding ->
        val modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    }
}