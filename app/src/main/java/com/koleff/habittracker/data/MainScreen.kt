package com.koleff.habittracker.data

sealed class MainScreen(val route: String) {
    object Dashboard : MainScreen("dashboard")
    object Search : MainScreen("search")
    object Add : MainScreen("add")
}