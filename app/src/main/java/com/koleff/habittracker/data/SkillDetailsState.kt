package com.koleff.habittracker.data

data class SkillDetailsState(
    var selectedSkill: Skill? = null,
    var isLoading: Boolean = true,
    var isError: Boolean = false,
    var error: String = "" //TODO: add custom error class
)