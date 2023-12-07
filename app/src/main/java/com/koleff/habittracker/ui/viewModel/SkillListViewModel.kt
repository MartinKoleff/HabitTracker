package com.koleff.habittracker.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koleff.habittracker.data.Skill
import com.koleff.habittracker.domain.repository.SkillRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SkillListViewModel @Inject constructor(
    private val skillRepository: SkillRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {
    private val _skills = MutableStateFlow<List<Skill>>(mutableListOf()) //TODO: add State class with real DataSource configuration
    val skills: StateFlow<List<Skill>> = _skills

    init{
        getSkills()
    }

    private fun getSkills() {
        viewModelScope.launch(dispatcher) {
            _skills.value = skillRepository.getSkills()
        }
    }
}

//.stateIn(
//        scope = viewModelScope,
//        started = SharingStarted.WhileSubscribed(5000),
//        initialValue = ResultWrapper.Loading,
//    )