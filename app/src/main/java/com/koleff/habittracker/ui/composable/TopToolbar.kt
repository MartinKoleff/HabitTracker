package com.koleff.habittracker.ui.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.koleff.habittracker.data.MainScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopToolbar(navController: NavHostController, title: String) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            NavigationItem(
                navController = navController,
                screen = null, //Backstack pop
                icon = Icons.Filled.ArrowBack,
                label = "Go back"
            )
        },
        actions = {
            NavigationItem(
                navController = navController,
                screen = MainScreen.Add,
                icon = Icons.Filled.Add,
                label = "Add new skill"
            )
        },
        scrollBehavior = scrollBehavior
    )
}

