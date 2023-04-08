package com.soufianesaadouni.sams.ui.view.attendance

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.soufianesaadouni.sams.data.repository.StudentRepository
import com.soufianesaadouni.sams.ui.view.ListTile
import com.soufianesaadouni.sams.ui.viewmodel.StudentViewModel

@Composable
fun StudentsTab(/*studentViewModel: StudentViewModel*/classeID: String = "Empty") {
    val studentRepository =
        StudentRepository(
            FirebaseFirestore.getInstance(),
            FirebaseAuth.getInstance(),
	    classeID)

    val students by StudentViewModel(studentRepository)
        .students
        .collectAsState(initial = emptyList())

    LazyColumn {
        items(students.size) { index ->
            ListTile(title = students.elementAt(index)!!.fullName)
        }
    }
}