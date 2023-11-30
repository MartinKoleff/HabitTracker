package com.koleff.habittracker.data.repository

import com.koleff.habittracker.R
import com.koleff.habittracker.data.Skill
import com.koleff.habittracker.data.SkillCategory
import com.koleff.habittracker.data.SkillType
import com.koleff.habittracker.domain.repository.SkillRepository
import java.lang.IndexOutOfBoundsException

class FakeSkillRepositoryImpl : SkillRepository {

    override suspend fun getSkills(): List<Skill> {
        val skillList = mutableListOf<Skill>()
        var skill: Skill
        val n = 27

        repeat(n) {
            skill = Skill(
                name = "Jetpack Compose ${it + 1}",
                description = "Learn Jetpack Compose framework in Android",
                imageId = R.drawable.jetpack_compose,
                type = SkillType.COMPLETABLE,
                category = SkillCategory.LEARNING
            )
            skillList.add(skill)
        }

        return skillList
    }

    override suspend fun getSkill(id: Int): Skill {
        return try {
            getSkills()[id - 1] //starts from 0
        }catch (e: IndexOutOfBoundsException){
            getSkills()[0]
        }
    }
}