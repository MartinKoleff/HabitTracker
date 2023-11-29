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

@Composable
fun BottomNavigationBar() {
    BottomAppBar(
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(Icons.Filled.Star, contentDescription = "Dashboard")
            }
            FloatingActionButton(onClick = { /* do something */ }) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search skill",
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Add new skill",
                )
            }
        }
    )
}