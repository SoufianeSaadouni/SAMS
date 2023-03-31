package com.soufianesaadouni.sams.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MyDialog(
    //TODO uncomment this
    /*isDialogOpened*/
) {
    var isDialogOpened by remember {
        mutableStateOf(true)
    }
    // Dialog
    if (isDialogOpened) {
        AlertDialog(
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true),
            onDismissRequest = { /*TODO*/ isDialogOpened = !isDialogOpened },
            content = {
                Column {
                    Box(modifier = Modifier.fillMaxSize()) {

                    }
                    Row {
                        Button(onClick = { /*TODO*/ }) {
                            Text("Button1", color = Color.Black)
                        }
                        Button(onClick = { /*TODO*/ }) {
                            Text("Button2", color = Color.Black)
                        }
                    }
                }
            },
        )
    }
}