package com.koleff.habittracker.ui.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.koleff.habittracker.data.MainScreen

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomAppBar(
        actions = {
            NavigationItem(
                modifier = Modifier.weight(1f),
                navController = navController,
                screen = MainScreen.Dashboard,
                icon = Icons.Filled.Star,
                label = "Dashboard"
            )

//            //Spacing between items
//            Spacer(
//                modifier = Modifier
//                    .weight(1f)
//                    .width(0.dp)
//            )

            NavigationItem(
                modifier = Modifier.weight(0.5f),
                navController = navController,
                screen = MainScreen.Search,
                icon = Icons.Filled.Search,
                label = "Search skill"
            )

//            //Spacing between items
//            Spacer(
//                modifier = Modifier
//                    .weight(1f)
//                    .width(0.dp)
//            )

            NavigationItem(
                modifier = Modifier.weight(1f),
                navController = navController,
                screen = MainScreen.Settings,
                icon = Icons.Filled.Settings,
                label = "Settings"
            )
        }
    )
}