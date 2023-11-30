package com.koleff.habittracker.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.koleff.habittracker.data.MainScreen
import com.koleff.habittracker.ui.composable.screen.DashboardScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = MainScreen.Dashboard.route,
                modifier = Modifier.padding()
            ) {
                composable(MainScreen.Dashboard.route) { DashboardScreen() }
//                composable(MainScreen.Search.route) { SearchScreen() }
//                composable(MainScreen.Add.route) { AddSkillScreen() }
            }
        }
    }
}

