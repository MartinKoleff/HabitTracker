package com.koleff.habittracker.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.koleff.habittracker.data.Skill

@Composable
fun SkillDetailsScreen(
    selectedSkill: Skill,
    navController: NavHostController
) {
    MainScreenScaffold("Skill details screen", navController) { innerPadding ->
        SkillCard(selectedSkill, innerPadding)
    }
}

@Composable
fun SkillCard(skill: Skill, paddingValues: PaddingValues) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = paddingValues.calculateTopPadding() + 16.dp,
                bottom = paddingValues.calculateBottomPadding(),
                start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                end = paddingValues.calculateStartPadding(LayoutDirection.Rtl)
            )
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