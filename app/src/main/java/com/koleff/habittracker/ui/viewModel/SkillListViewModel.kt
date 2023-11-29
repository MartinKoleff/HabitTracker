package com.koleff.habittracker.ui.viewModel

import com.koleff.habittracker.R
import com.koleff.habittracker.data.Skill
import com.koleff.habittracker.data.SkillCategory
import com.koleff.habittracker.data.SkillType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SkillListViewModel {
    private val _skill = MutableStateFlow<List<Skill>?>(null)
    val skill: StateFlow<List<Skill>?> = _skill

    init{
        mockupSkills()
    }

    private fun mockupSkills() {
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

        _skill.value = skillList
    }
}