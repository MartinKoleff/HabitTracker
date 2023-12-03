package com.koleff.habittracker.ui.composable.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.koleff.habittracker.data.MainScreen
import com.koleff.habittracker.ui.composable.MainScreenScaffold
import com.koleff.habittracker.ui.composable.SettingsList

@Composable
fun SettingsScreen(navController: NavHostController) {
    MainScreenScaffold("Settings", navController) { innerPadding ->

        SettingsList(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}