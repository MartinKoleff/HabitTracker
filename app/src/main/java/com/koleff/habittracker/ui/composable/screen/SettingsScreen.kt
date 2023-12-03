package com.koleff.habittracker.ui.composable.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.koleff.habittracker.data.MainScreen
import com.koleff.habittracker.ui.composable.MainScreenScaffold

@Composable
fun SettingsScreen(navController: NavHostController) {
    MainScreenScaffold("Settings", navController) {

    }
}