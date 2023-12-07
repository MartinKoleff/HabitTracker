package com.koleff.habittracker.ui.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.koleff.habittracker.data.Skill
import com.koleff.habittracker.data.SkillDetailsState
import com.koleff.habittracker.domain.repository.SkillRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SkillDetailsViewModel @AssistedInject constructor(
    private val skillRepository: SkillRepository,
    @Assisted private val skillId: Int,
    @Assisted private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _state = MutableStateFlow(SkillDetailsState())
    val state: StateFlow<SkillDetailsState> = _state

    init {
        getSkill(id = skillId)
    }

    private fun getSkill(id: Int) {
        viewModelScope.launch(dispatcher) {
            _state.value = SkillDetailsState(
                isLoading = true
            )

            val selectedSkill = skillRepository.getSkill(id)
            Log.d("SkillDetailsViewModel", "Fetched new data for id: $id -> $selectedSkill")

            _state.value = SkillDetailsState(
                isLoading = false,
                selectedSkill = selectedSkill
            )
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(skillId: Int, dispatcher: CoroutineDispatcher): SkillDetailsViewModel
    }

    companion object {
        fun provideExerciseViewModelFactory(
            factory: Factory,
            skillId: Int,
            dispatcher: CoroutineDispatcher = Dispatchers.Main
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return factory.create(skillId, dispatcher) as T
            }
        }
    }
}


