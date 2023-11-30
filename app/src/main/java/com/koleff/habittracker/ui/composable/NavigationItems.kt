package com.koleff.habittracker.ui.composable

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.koleff.habittracker.data.MainScreen

@Composable
fun NavigationItem(
    navController: NavHostController,
    screen: MainScreen?,
    icon: ImageVector,
    label: String
) {
    IconButton(
        onClick = {
            screen?.let {
                navController.navigate(screen.route)
                return@IconButton
            } ?: run {
                navController.popBackStack()

                val currentBackStackEntry = navController.currentBackStackEntry ?: return@IconButton
                currentBackStackEntry.destination.route?.let { route ->
                    navController.navigate(route)
                }

                //TODO: Add Dashboard if backstack is empty?
            }
        }
    ) {
        Icon(imageVector = icon, contentDescription = label)
    }
}

@Composable
fun FloatingNavigationItem(
    navController: NavHostController,
    screen: MainScreen?,
    icon: ImageVector,
    label: String
) {
    FloatingActionButton(
        onClick = {
            screen?.let {
                navController.navigate(screen.route)
                return@FloatingActionButton
            } ?: run {
                navController.popBackStack()

                val currentBackStackEntry = navController.currentBackStackEntry ?: return@FloatingActionButton
                currentBackStackEntry.destination.route?.let { route ->
                    navController.navigate(route)
                }

                //TODO: Add Dashboard if backstack is empty?
            }
        }
    ) {
        Icon(imageVector = icon, contentDescription = label)
    }
}