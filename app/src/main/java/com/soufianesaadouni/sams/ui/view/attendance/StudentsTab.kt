package com.soufianesaadouni.sams.ui.view

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.soufianesaadouni.sams.data.model.Classe
import com.soufianesaadouni.sams.ui.viewmodel.StudentViewModel

@Composable
fun StudentsTab(/*studentViewModel: StudentViewModel*/){
    val studentViewModel = StudentViewModel()

    val student by studentViewModel.studentFlow.collectAsState(initial = Classe("none","none","none"))

    student?.let { Text(it.fullName) }
}