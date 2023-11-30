package com.koleff.habittracker.ui.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koleff.habittracker.data.Skill
import com.koleff.habittracker.domain.repository.SkillRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SkillDetailsViewModel @Inject constructor(
    private val skillRepository: SkillRepository,
//    private val selectedSkillId: Int = -1,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private var _skill = MutableStateFlow<Skill?>(null)
    val skill: StateFlow<Skill?> = _skill

//    init {
//        getSkill(selectedSkillId)
//    }

     suspend fun getSkill(id: Int) {
        withContext(viewModelScope.coroutineContext + dispatcher) {
            _skill.value = skillRepository.getSkill(id)
        }
    }
}