package com.koleff.habittracker.data.repository

import com.koleff.habittracker.data.Skill
import com.koleff.habittracker.data.datasource.SkillDataSource
import com.koleff.habittracker.domain.repository.SkillRepository
import kotlinx.coroutines.delay

class MockupSkillRepositoryImpl(private val mockupSkillDataSource: SkillDataSource) : SkillRepository {

    override suspend fun getSkills(): List<Skill> {
        return mockupSkillDataSource.getSkills()
    }

    override suspend fun getSkill(id: Int): Skill {
        delay(5000) //Simulate API request
        return mockupSkillDataSource.getSkill(id)
    }
}