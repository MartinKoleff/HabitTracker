package com.koleff.habittracker.ui.composable.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.koleff.habittracker.ui.composable.BottomNavigationBar
import com.koleff.habittracker.ui.composable.SkillGrid
import com.koleff.habittracker.ui.composable.TopToolbar
import com.koleff.habittracker.ui.viewModel.SkillListViewModel
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    skillListViewModel: SkillListViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopToolbar("Title")
        },
        bottomBar = {
            BottomNavigationBar()
        }
    ) { innerPadding ->
        val data = skillListViewModel.skills.collectAsState()

        SkillGrid(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            skillList = data.value ?: listOf()
        )
    }
}