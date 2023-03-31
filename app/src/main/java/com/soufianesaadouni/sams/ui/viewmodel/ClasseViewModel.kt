package com.soufianesaadouni.sams.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.soufianesaadouni.sams.data.model.Student
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class ClasseViewModel: ViewModel() {
    // Creating a MutableStateFlow to hold the student data
    private val _studentFlow= MutableStateFlow<Student?>(null)

    // Exposing the student as a read only flow
    val studentFlow:Flow<Student?> = _studentFlow

    // Updating the student
    fun updateStudent(student: Student){
        _studentFlow.value = student
    }

    fun removeStudent(){

    }
}