package com.soufianesaadouni.sams.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soufianesaadouni.sams.data.model.Student
import com.soufianesaadouni.sams.data.repository.StudentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StudentViewModel(private val repository: StudentRepository) : ViewModel() {
    // Creating a MutableStateFlow to hold the student data
    private val _students = MutableStateFlow<List<Student?>>(emptyList())
    val students: StateFlow<List<Student?>>  = _students

    private fun fetch() {
        viewModelScope.launch {
            _students.value = repository.fetch()
        }
    }

    fun add(student: Student) {
        viewModelScope.launch {
            repository.add(student)
            fetch()
        }
    }

    // Updating the student
    fun update(studentID: String, student: Student) {
        viewModelScope.launch {
            repository.update(studentID, student)
            fetch()
        }
    }

    fun remove(studentID: String) {
        viewModelScope.launch {
            repository.delete(studentID)
            fetch()
        }
    }
}