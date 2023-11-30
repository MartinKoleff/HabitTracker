package com.koleff.habittracker.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.koleff.habittracker.common.DataManager
import com.koleff.habittracker.data.MainScreen
import com.koleff.habittracker.ui.composable.SkillDetailsScreen
import com.koleff.habittracker.ui.composable.screen.AddSkillScreen
import com.koleff.habittracker.ui.composable.screen.DashboardScreen
import com.koleff.habittracker.ui.composable.screen.SearchScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val navController = rememberNavController()

            //Put inside scaffold?
            NavHost(
                navController = navController,
                startDestination = MainScreen.Dashboard.route
            ) {
                composable(MainScreen.Dashboard.route) { DashboardScreen(navController) }
                composable(MainScreen.SkillDetails.route) { SkillDetailsScreen(DataManager.selectedSkill, navController) }
                composable(MainScreen.Search.route) { SearchScreen(navController) }
                composable(MainScreen.Add.route) { AddSkillScreen(navController) }
            }
        }
    }
}

