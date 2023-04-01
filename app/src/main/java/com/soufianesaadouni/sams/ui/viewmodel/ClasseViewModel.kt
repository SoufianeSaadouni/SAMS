package com.soufianesaadouni.sams.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soufianesaadouni.sams.data.model.Classe
import com.soufianesaadouni.sams.data.repository.ClasseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ClasseViewModel(private val repository: ClasseRepository) : ViewModel() {
    // Creating a MutableStateFlow to hold the classe data
    private val _classes = MutableStateFlow<List<Classe?>>(emptyList())
    val classes: StateFlow<List<Classe?>> = _classes

    fun fetch() {
        viewModelScope.launch {
            _classes.value = repository.fetch()
        }
    }

    fun add(classe: Classe) {
        viewModelScope.launch {
            repository.add(classe)
            fetch()
        }
    }

    // Updating the classe
    fun update(classeID: String, classe: Classe) {
        viewModelScope.launch {
            repository.update(classeID, classe)
            fetch()
        }
    }

    fun remove(classeID: String) {
        viewModelScope.launch {
            repository.delete(classeID)
            fetch()
        }
    }
}