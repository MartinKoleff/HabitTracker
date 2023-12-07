package com.koleff.habittracker.ui.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.koleff.habittracker.data.Skill
import com.koleff.habittracker.domain.repository.SkillRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SkillDetailsViewModel @AssistedInject constructor(
    private val skillRepository: SkillRepository,
    @Assisted private val skillId: Int,
    @Assisted private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private var _skill: MutableState<Skill?> = mutableStateOf(null)
    val skill: State<Skill?> = _skill

    fun getSkill(id: Int) {
        _skill.value = null
        Log.d("SkillDetailsViewModel", "Cleared previous state for id: $id")
    init {
        getSkill(id = skillId)
    }

        viewModelScope.launch(dispatcher) {
            _skill.value = skillRepository.getSkill(id)
            Log.d("SkillDetailsViewModel", "Fetched new data for id: $id")

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


