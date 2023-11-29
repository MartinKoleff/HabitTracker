package com.koleff.habittracker.ui.composable.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.koleff.habittracker.ui.composable.BottomNavigationBar
import com.koleff.habittracker.ui.composable.SkillGrid
import com.koleff.habittracker.ui.composable.TopToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopToolbar("Title")
        },
        bottomBar = {
            BottomNavigationBar()
        }
    ) { innerPadding ->
        SkillGrid(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            skillList = skillList
        )
    }
}