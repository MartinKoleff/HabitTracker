package com.koleff.habittracker.ui.composable.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.koleff.habittracker.data.MainScreen
import com.koleff.habittracker.ui.composable.navigation.FloatingNavigationItem
import com.koleff.habittracker.ui.composable.navigation.NavigationItem

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
                screen = MainScreen.Settings,
                icon = Icons.Filled.Settings,
                label = "Settings"
            )
        }
    )
}