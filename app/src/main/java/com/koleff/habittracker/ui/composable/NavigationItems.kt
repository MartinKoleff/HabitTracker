package com.koleff.habittracker.ui.composable

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
//            if (navController.currentBackStackEntry == null) return@IconButton
            //No need to navigate back if already on the Dashboard screen or no items inside backstack are found

            screen?.let {
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

                navController.popBackStack()

                Log.d(
                    "BACKSTACK AFTER POP",
                    "${navController.currentBackStackEntry}, ${navController.currentBackStack.value.size}"
                )

//                val navigationRoute = navController.currentBackStackEntry?.destination?.route
//                    ?: MainScreen.Dashboard.route
//                navController.navigate(navigationRoute)
//                TODO: Add Dashboard if backstack is empty?
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
                navController.navigate(screen.route)
                return@FloatingActionButton
            } ?: run {
                navController.popBackStack()

                val currentBackStackEntry =
                    navController.currentBackStackEntry ?: return@FloatingActionButton
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