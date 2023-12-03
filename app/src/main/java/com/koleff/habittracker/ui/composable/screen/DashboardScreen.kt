package com.koleff.habittracker.ui.composable.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.koleff.habittracker.ui.composable.MainScreenScaffold
import com.koleff.habittracker.ui.composable.SkillGrid
import com.koleff.habittracker.ui.viewModel.SkillListViewModel

@Composable
fun DashboardScreen(
    navController: NavHostController,
    skillListViewModel: SkillListViewModel = hiltViewModel()
) {
    MainScreenScaffold("Dashboard", navController) { innerPadding ->
        val data = skillListViewModel.skills.collectAsState()

        SkillGrid(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            navController = navController,
            skillList = data.value ?: listOf()
        )
    }
}