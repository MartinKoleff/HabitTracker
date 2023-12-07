package com.koleff.habittracker.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.koleff.habittracker.ui.composable.navigation.SetupNavGraph
import com.koleff.habittracker.ui.viewModel.SkillDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var skillDetailsViewModelFactory: SkillDetailsViewModel.Factory

    @OptIn(ExperimentalComposeUiApi::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val skillDetailsViewModel by viewModels<SkillDetailsViewModel> {
//            SkillDetailsViewModel.provideExerciseViewModelFactory(factory = skillDetailsViewModelFactory, skillId = selectedSkillId)
//        }

        setContent {
            val navController = rememberNavController()
            SetupNavGraph(navController = navController, skillDetailsViewModelFactory = skillDetailsViewModelFactory)
        }
    }
}

