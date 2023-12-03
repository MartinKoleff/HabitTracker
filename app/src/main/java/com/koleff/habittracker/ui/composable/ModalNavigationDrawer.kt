package com.koleff.habittracker.ui.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalNavigationDrawer(
    initialDrawerState: DrawerState,
    drawerContent: @Composable () -> Unit = { NavigationDrawerSheet() },
    screenContent: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = initialDrawerState,
        drawerContent = {
           drawerContent()
        },
        gesturesEnabled = true
    ) {
        screenContent()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerSheet() {
    ModalDrawerSheet {
        Text("Drawer title", modifier = Modifier.padding(16.dp))
        Divider()
        NavigationDrawerItem(
            label = { Text(text = "Drawer Item") },
            selected = false,
            onClick = { }
        )
        //TODO: add profile option for logout
        //TODO: add night mode option
        //TODO: add user agreement option
    }
}
