package com.koleff.habittracker.ui.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koleff.habittracker.data.Skill
import com.koleff.habittracker.domain.repository.SkillRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SkillDetailsViewModel @Inject constructor(
    private val skillRepository: SkillRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private var _skill: MutableState<Skill?> = mutableStateOf(null)
    val skill: State<Skill?> = _skill

    fun getSkill(id: Int) {
        _skill.value = null
        Log.d("SkillDetailsViewModel", "Cleared previous state for id: $id")

        viewModelScope.launch(dispatcher) {
            _skill.value = skillRepository.getSkill(id)
            Log.d("SkillDetailsViewModel", "Fetched new data for id: $id")
        }
    }
}
