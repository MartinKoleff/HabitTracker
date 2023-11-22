package com.koleff.habittracker.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koleff.habittracker.domain.Skill
import com.koleff.habittracker.domain.SkillCategory
import com.koleff.habittracker.domain.SkillType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SkillViewModel : ViewModel() {
    private val _skill = MutableStateFlow<Skill?>(null)
    val skill: StateFlow<Skill?> = _skill

    fun updateSkill() {
        viewModelScope.launch {
            _skill.value = Skill(
                "Learning Jetpack Compose",
                SkillType.COMPLETABLE,
                SkillCategory.LEARNING
            )
        }
    }
}