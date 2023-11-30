package com.koleff.habittracker.common.dependencyInjection

import com.koleff.habittracker.domain.repository.SkillRepository
import com.koleff.habittracker.ui.viewModel.SkillDetailsViewModel
import com.koleff.habittracker.ui.viewModel.SkillListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun providesSkillListViewModel(skillRepository: SkillRepository): SkillListViewModel{
        return SkillListViewModel(skillRepository)
    }

    @Provides
    @ViewModelScoped
    fun providesSkillDetailsViewModel(skillRepository: SkillRepository): SkillDetailsViewModel{
        return SkillDetailsViewModel(skillRepository)
    }
}