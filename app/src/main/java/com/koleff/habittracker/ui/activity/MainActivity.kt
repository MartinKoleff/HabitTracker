package com.koleff.habittracker.ui.activity

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
import com.koleff.habittracker.domain.Skill
import com.koleff.habittracker.ui.theme.HabitTrackerTheme
import com.koleff.habittracker.ui.viewModel.SkillViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: SkillViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabitTrackerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyComposableActivity(viewModel)
                }
            }
        }
    }
}

@Composable
fun MyComposableActivity(viewModel: SkillViewModel) {
    val skill by viewModel.skill.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Click me",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = {
                viewModel.updateSkill()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Click me")
        }

        // Display the skill information if it is not null
        skill?.let {
            SkillCard(skill = it)
        }
    }
}

@Composable
fun SkillCard(skill: Skill) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Skill Name: ${skill.name}", fontWeight = FontWeight.Bold)
            Text(text = "Type: ${skill.type}")
            Text(text = "Category: ${skill.category}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyComposableActivityPreview() {
    HabitTrackerTheme {
        MyComposableActivity(SkillViewModel())
    }
}