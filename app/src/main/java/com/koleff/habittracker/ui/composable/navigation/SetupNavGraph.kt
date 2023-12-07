package com.koleff.habittracker.ui.composable.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.koleff.habittracker.data.MainScreen
import com.koleff.habittracker.ui.composable.SkillDetailsScreen
import com.koleff.habittracker.ui.composable.screen.AddSkillScreen
import com.koleff.habittracker.ui.composable.screen.DashboardScreen
import com.koleff.habittracker.ui.composable.screen.SearchScreen
import com.koleff.habittracker.ui.composable.screen.SettingsScreen
import com.koleff.habittracker.ui.viewModel.SkillDetailsViewModel

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    skillDetailsViewModelFactory: SkillDetailsViewModel.Factory
) {
    NavHost(
        navController = navController,
        startDestination = MainScreen.Dashboard.route
    ) {
        composable(MainScreen.Dashboard.route) { DashboardScreen(navController) }
        composable(MainScreen.SkillDetails.route) { backStackEntry ->
            val selectedSkillId =
                backStackEntry.arguments?.getString("skill_id")?.toInt() ?: -1

            val skillDetailsViewModel = viewModel<SkillDetailsViewModel>(
                factory = SkillDetailsViewModel.provideExerciseViewModelFactory(
                    factory = skillDetailsViewModelFactory,
                    skillId = selectedSkillId
                )
            )

            SkillDetailsScreen(
                selectedSkillId = selectedSkillId,
                navController = navController,
                skillDetailsViewModel = skillDetailsViewModel
            )
        }
        composable(MainScreen.Search.route) { SearchScreen(navController) }
        composable(MainScreen.Add.route) { AddSkillScreen(navController) }
        composable(MainScreen.Settings.route) { SettingsScreen(navController) }
    }
}