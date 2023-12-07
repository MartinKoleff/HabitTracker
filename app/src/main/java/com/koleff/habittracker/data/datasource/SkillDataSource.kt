package com.koleff.habittracker.data.datasource

import com.koleff.habittracker.data.Skill

interface SkillDataSource {
    fun getSkills(): List<Skill>

    fun getSkill(id: Int): Skill
}