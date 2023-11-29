package com.koleff.habittracker.data


data class Skill (
    val name: String,
    val description: String,
    val type: SkillType,
    val category: SkillCategory,
    val imageId: Int
)