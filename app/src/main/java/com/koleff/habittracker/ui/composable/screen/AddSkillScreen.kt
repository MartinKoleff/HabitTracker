package com.koleff.habittracker.ui.composable.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.koleff.habittracker.ui.composable.BottomNavigationBar
import com.koleff.habittracker.ui.composable.MainScreenScaffold
import com.koleff.habittracker.ui.composable.TopToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSkillScreen(navController: NavHostController) {
    MainScreenScaffold("Add new skill", navController) {

    }
}