package com.koleff.habittracker.common.dependencyInjection

import com.koleff.habittracker.data.datasource.MockupSkillDataSource
import com.koleff.habittracker.data.datasource.SkillDataSource
import com.koleff.habittracker.data.repository.MockupSkillRepositoryImpl
import com.koleff.habittracker.domain.repository.SkillRepository
import com.koleff.habittracker.ui.viewModel.SkillListViewModel
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
    fun provideSkillRepositoryImpl(skillDataSource: SkillDataSource): SkillRepository {
        return MockupSkillRepositoryImpl(skillDataSource)
    }

    @Provides
    @Singleton
    fun provideSkillListViewModel(skillRepository: SkillRepository): SkillListViewModel {
        return SkillListViewModel(skillRepository)
    }

    @Provides
    @Singleton
    fun provideSkillDataSource(mockupSkillDataSource: SkillDataSource): SkillDataSource {
        return MockupSkillDataSource()
    }
}