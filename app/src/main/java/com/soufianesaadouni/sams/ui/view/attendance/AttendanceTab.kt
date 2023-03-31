package com.soufianesaadouni.sams.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.material.datepicker.MaterialDatePicker

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AttendanceTab(){
        val datePicker = DatePickerDialog(
            onDismissRequest = { /*TODO*/ },
            confirmButton = { /*TODO*/ }) {
        }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { /*TODO*/
//            datePicker.
        }) {
            Text("Set Date and Time")
        }
        Text("ATTENDANCE TAB")
        Box(modifier = Modifier.fillMaxSize()) {

        }
    }
}