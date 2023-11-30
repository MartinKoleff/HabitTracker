package com.koleff.habittracker.ui.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.koleff.habittracker.data.MainScreen

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomAppBar(
        actions = {
            NavigationItem(
                navController = navController,
                screen = MainScreen.Dashboard,
                icon = Icons.Filled.Star,
                label = "Dashboard"
            )
            FloatingActionButton(onClick = { navController.navigate(MainScreen.Search.route) }) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search skill",
                )
            }
            NavigationItem(
                navController = navController,
                screen = MainScreen.Add,
                icon = Icons.Filled.Add,
                label = "Add new skill"
            )
        }
    )
}

@Composable
fun NavigationItem(
    navController: NavHostController,
    screen: MainScreen,
    icon: ImageVector,
    label: String
) {
    IconButton(
        onClick = { navController.navigate(screen.route) }
    ) {
        Icon(imageVector = icon, contentDescription = label)
    }
}