package com.soufianesaadouni.sams.ui.view.dialogs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Preview(showBackground = true)
@Composable
fun AddClasse(
    onSaveClick: (String) -> Unit = {},
    onDismiss: () -> Unit = {}

) {
    var classeName by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            usePlatformDefaultWidth = false
        )
    ) {
        Card {
            Box(
                modifier = Modifier
                    .padding(16.dp),
                contentAlignment = Alignment.Center,
                content = {
                    Column(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        content = {
                            TextField(
                                value = classeName,
                                onValueChange = { classeName = it },
                                label = { Text("Classe Name") },
                                placeholder = { Text("Enter your classe name here") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            )
                            Spacer(modifier = Modifier.size(16.dp))
                            Row {
                                Button(onClick = onDismiss) {
                                    Text("Cancel")
                                }
                                Spacer(modifier = Modifier.size(16.dp))
                                Button(onClick = { onSaveClick(classeName.text) }) {
                                    Text("Save")
                                }
                            }
                        }
                    )
                }
            )
        }
    }
}