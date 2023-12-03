package com.koleff.habittracker.ui.composable

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.koleff.habittracker.data.MainScreen

/**
 * When screen is null -> navigate to latest backstack entry after popping the details screen
 * */
@Composable
fun NavigationItem(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    screen: MainScreen?,
    icon: ImageVector,
    label: String
) {
    val isNavigationInProgress = remember {
        mutableStateOf(false)
    }

    val navControllerRoute = remember {
        navController.currentBackStackEntry!!.destination.route
    }

    val isListenerRegistered by remember { mutableStateOf(false) }

    if (!isListenerRegistered) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            isNavigationInProgress.value = destination.route != navControllerRoute

            Log.d(
                "Navigation",
                "Navigation in progress: ${isNavigationInProgress.value}, Destination: ${destination.route}, Current destination: $navControllerRoute"
            )
        }
    }

    IconButton(
        modifier = modifier,
        onClick = {
            screen?.let {
                if (navControllerRoute == screen.route || isNavigationInProgress.value) return@IconButton

                navController.navigate(screen.route)

                Log.d(
                    "Navigation",
                    "Backstack: ${navController.currentBackStackEntry}, ${navController.currentBackStack.value.size}"
                )

                return@IconButton
            } ?: run {
                Log.d(
                    "Navigation",
                    "Backstack before pop: ${navController.currentBackStackEntry}, ${navController.currentBackStack.value.size}"
                )
                //Starting navigation and current navigation
                if (navController.currentBackStack.value.size == 2) return@IconButton

                navController.popBackStack()

                Log.d(
                    "Navigation",
                    "Backstack after pop: ${navController.currentBackStackEntry}, ${navController.currentBackStack.value.size}"
                )
            }
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
        ) {
            Icon(imageVector = icon, contentDescription = label)

            Spacer(modifier = Modifier.padding(15.dp))

            Text(
                text = label
            )
        }
    }
}


/**
 * When screen is null -> navigate to latest backstack entry after popping the details screen
 * */
@Composable
fun FloatingNavigationItem(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    screen: MainScreen?,
    icon: ImageVector,
    label: String
) {
    val isNavigationInProgress = remember {
        mutableStateOf(false)
    }

    val navControllerRoute = remember {
        navController.currentBackStackEntry!!.destination.route
    }

    val isListenerRegistered by remember { mutableStateOf(false) }

    if (!isListenerRegistered) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            isNavigationInProgress.value = destination.route != navControllerRoute

            Log.d(
                "Navigation",
                "Navigation in progress: ${isNavigationInProgress.value}, Destination: ${destination.route}, Current destination: $navControllerRoute"
            )
        }
    }

    navController.addOnDestinationChangedListener { _, destination, _ ->
        isNavigationInProgress.value = destination.route == navControllerRoute

        Log.d(
            "Navigation",
            "Navigation in progress: ${isNavigationInProgress.value}, Destination: ${destination.route}, Current destination: $navControllerRoute"
        )
    }

    FloatingActionButton(
        modifier = modifier,
        onClick = {
            screen?.let {
                if (navControllerRoute == screen.route || isNavigationInProgress.value) return@FloatingActionButton

                navController.navigate(screen.route)

                Log.d(
                    "Navigation",
                    "Backstack: ${navController.currentBackStackEntry}, ${navController.currentBackStack.value.size}"
                )

                return@FloatingActionButton
            } ?: run {
                Log.d(
                    "Navigation",
                    "Backstack before pop: ${navController.currentBackStackEntry}, ${navController.currentBackStack.value.size}"
                )

                //Starting navigation and current navigation
                if (navController.currentBackStack.value.size == 2) return@FloatingActionButton

                navController.popBackStack()

                Log.d(
                    "Navigation",
                    "Backstack after pop: ${navController.currentBackStackEntry}, ${navController.currentBackStack.value.size}"
                )
            }
        }
    ) {
        Icon(imageVector = icon, contentDescription = label)
    }
}