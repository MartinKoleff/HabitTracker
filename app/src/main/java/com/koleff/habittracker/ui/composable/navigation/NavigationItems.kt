package com.koleff.habittracker.ui.composable.navigation

import android.util.Log
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.koleff.habittracker.data.MainScreen

/**
 * When screen is null -> navigate to latest backstack entry after popping the details screen
 * */
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
                if(navController.currentBackStackEntry!!.destination.route == screen.route) return@IconButton

                navController.navigate(screen.route)

                Log.d(
                    "BACKSTACK",
                    "${navController.currentBackStackEntry}, ${navController.currentBackStack.value.size}"
                )

                return@IconButton
            } ?: run {
                Log.d(
                    "BACKSTACK BEFORE POP",
                    "${navController.currentBackStackEntry}, ${navController.currentBackStack.value.size}"
                )
                //Starting navigation and current navigation
                if(navController.currentBackStack.value.size == 2) return@IconButton

                navController.popBackStack()

                Log.d(
                    "BACKSTACK AFTER POP",
                    "${navController.currentBackStackEntry}, ${navController.currentBackStack.value.size}"
                )
            }
        }
    ) {
        Icon(imageVector = icon, contentDescription = label)
    }
}


/**
 * When screen is null -> navigate to latest backstack entry after popping the details screen
 * */
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
                if(navController.currentBackStackEntry!!.destination.route == screen.route) return@FloatingActionButton

                navController.navigate(screen.route)

                Log.d(
                    "BACKSTACK",
                    "${navController.currentBackStackEntry}, ${navController.currentBackStack.value.size}"
                )

                return@FloatingActionButton
            } ?: run {
                Log.d(
                    "BACKSTACK BEFORE POP",
                    "${navController.currentBackStackEntry}, ${navController.currentBackStack.value.size}"
                )

                //Starting navigation and current navigation
                if(navController.currentBackStack.value.size == 2) return@FloatingActionButton

                navController.popBackStack()

                Log.d(
                    "BACKSTACK AFTER POP",
                    "${navController.currentBackStackEntry}, ${navController.currentBackStack.value.size}"
                )
            }
        }
    ) {
        Icon(imageVector = icon, contentDescription = label)
    }
}