package com.koleff.habittracker.ui.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.koleff.habittracker.ui.composable.navigation.BottomNavigationBar
import com.koleff.habittracker.ui.composable.navigation.TopToolbar

@Composable
fun MainScreenScaffold(
    screenTitle: String,
    navController: NavHostController,
    content: @Composable (paddingValues: PaddingValues) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopToolbar(navController = navController, title = screenTitle)
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        content(innerPadding)
    }
}