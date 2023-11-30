package com.koleff.habittracker.ui.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
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

            //Spacing between items
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .width(0.dp)
            )

            FloatingNavigationItem(
                navController = navController,
                screen = MainScreen.Search,
                icon = Icons.Filled.Search,
                label = "Search skill"
            )

            //Spacing between items
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .width(0.dp)
            )
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

@Composable
fun FloatingNavigationItem(
    navController: NavHostController,
    screen: MainScreen,
    icon: ImageVector,
    label: String
) {
    FloatingActionButton(
        onClick = { navController.navigate(screen.route) }
    ) {
        Icon(imageVector = icon, contentDescription = label)
    }
}