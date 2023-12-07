package com.koleff.habittracker.data.datasource

import com.koleff.habittracker.R
import com.koleff.habittracker.data.Skill
import com.koleff.habittracker.data.SkillCategory
import com.koleff.habittracker.data.SkillType
import java.lang.IndexOutOfBoundsException

class MockupSkillDataSource: SkillDataSource {
    override fun getSkills(): List<Skill> {
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

        return skillList
    }

    override fun getSkill(id: Int): Skill {
        return try {
            getSkills()[id] //starts from 0
        } catch (e: IndexOutOfBoundsException) {
            getSkills()[0]
        }
    }
}