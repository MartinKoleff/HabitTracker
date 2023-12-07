package com.koleff.habittracker.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.koleff.habittracker.data.Skill
import com.koleff.habittracker.ui.viewModel.SkillDetailsViewModel

@Composable
fun SkillDetailsScreen(
    selectedSkillId: Int,
    skillDetailsViewModel: SkillDetailsViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val skilLState by skillDetailsViewModel.state.collectAsState()

    MainScreenScaffold("Skill details screen $selectedSkillId", navController) { innerPadding ->
        if (skilLState.isLoading) {
            LoadingWheel(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        } else {
            skilLState.selectedSkill?.let {
                SkillCard(skilLState.selectedSkill!!, innerPadding)
            }
        }
    }
}

@Composable
fun SkillCard(skill: Skill, paddingValues: PaddingValues) { //TODO: new details screen...
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