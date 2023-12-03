package com.koleff.habittracker.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.koleff.habittracker.data.MainScreen
import com.koleff.habittracker.ui.composable.SkillDetailsScreen
import com.koleff.habittracker.ui.composable.navigation.SetupNavGraph
import com.koleff.habittracker.ui.composable.screen.AddSkillScreen
import com.koleff.habittracker.ui.composable.screen.DashboardScreen
import com.koleff.habittracker.ui.composable.screen.SearchScreen
import com.koleff.habittracker.ui.composable.screen.SettingsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val navController = rememberNavController()
            SetupNavGraph(navController = navController)
        }
    }
}

