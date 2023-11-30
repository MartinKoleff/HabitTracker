package com.koleff.habittracker.domain.repository

import com.koleff.habittracker.data.Skill

interface SkillRepository {

    suspend fun getSkills(): List<Skill> //TODO: refactor to Flow
    suspend fun getSkill(id: Int): Skill //TODO: refactor to Flow
}