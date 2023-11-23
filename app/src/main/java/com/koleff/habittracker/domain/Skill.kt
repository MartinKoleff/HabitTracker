package com.koleff.habittracker.domain


data class Skill (
    val name: String,
    val description: String,
    val type: SkillType,
    val category: SkillCategory,
    val imageId: Int
)