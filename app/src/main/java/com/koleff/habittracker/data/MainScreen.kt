package com.koleff.habittracker.data

sealed class MainScreen(val route: String) {
    object Dashboard : MainScreen("dashboard")
    object Search : MainScreen("search")
    object Add : MainScreen("add")
    object SkillDetails : MainScreen("skill_details/{skill_id}"){
            fun createRoute(skillId: Int) = "skill_details/$skillId"
    }
}