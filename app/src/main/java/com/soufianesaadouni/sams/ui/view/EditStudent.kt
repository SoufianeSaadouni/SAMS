package com.soufianesaadouni.sams.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.soufianesaadouni.sams.data.model.Student
import com.soufianesaadouni.sams.ui.viewmodel.StudentViewModel

@Preview(showBackground = true)
@Composable
fun AddStudent() {
    // TODO pass studentViewModel as a parameter
    //val studentViewModel = StudentViewModel()

    // Used to update a student
    val (fullName, setName) = remember {
        mutableStateOf("")
    }

    val (email, setEmail) = remember {
        mutableStateOf("")
    }


    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextField(
            value = fullName,
            onValueChange = { setName(it) },
            label = { Text("Full Name") },
            placeholder = { Text("Enter full name here") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

            )
        TextField(
            value = email,
            onValueChange = { setEmail(it) },
            label = { Text("Email") },
            placeholder = { Text("Enter email here") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

            )

        //Spacer(modifier = Modifier.size(24.dp))
        Button(onClick = { /*TODO*/
            //studentViewModel.update(Student("idHere", fullName, email))
        }) {
            Text("Add", modifier = Modifier.padding(4.dp))
        }
    }
}