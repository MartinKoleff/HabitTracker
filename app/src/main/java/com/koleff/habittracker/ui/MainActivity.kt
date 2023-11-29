package com.koleff.habittracker.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.koleff.habittracker.R
import com.koleff.habittracker.domain.Skill
import com.koleff.habittracker.domain.SkillCategory
import com.koleff.habittracker.domain.SkillType
import com.koleff.habittracker.ui.composable.BottomNavigationBar
import com.koleff.habittracker.ui.composable.SkillGrid
import com.koleff.habittracker.ui.composable.TopToolbar
import com.koleff.habittracker.ui.theme.HabitTrackerTheme
import com.koleff.habittracker.ui.viewModel.SkillViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: SkillViewModel by viewModels() //Used for MyComposableActivity

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val skillList: List<Skill> = mockupSkills()

        setContent {
            HabitTrackerTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopToolbar()
                    },
                    bottomBar = {
                        BottomNavigationBar()
                    }
                ) { innerPadding ->
                    SkillGrid(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        skillList = skillList
                    )
                }

//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    MyComposableActivity(viewModel)
//                }
            }
        }
    }

    private fun mockupSkills(): List<Skill> {
        val skillList = mutableListOf<Skill>()
        var skill: Skill
        val n = 27

        repeat(n) {
            skill = Skill(
                name = "Jetpack Compose $it",
                description = "Learn Jetpack Compose framework in Android",
                imageId = R.drawable.jetpack_compose,
                type = SkillType.COMPLETABLE,
                category = SkillCategory.LEARNING
            )
            skillList.add(skill)
        }

        return skillList
    }
}

