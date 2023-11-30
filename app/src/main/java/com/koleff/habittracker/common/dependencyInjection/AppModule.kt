package com.koleff.habittracker.common.dependencyInjection

import com.koleff.habittracker.data.repository.FakeSkillRepositoryImpl
import com.koleff.habittracker.domain.repository.SkillRepository
import com.koleff.habittracker.ui.viewModel.SkillDetailsViewModel
import com.koleff.habittracker.ui.viewModel.SkillListViewModel
import dagger.Component.Factory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFakeSkillRepositoryImpl(): SkillRepository {
        return FakeSkillRepositoryImpl()
    }
}