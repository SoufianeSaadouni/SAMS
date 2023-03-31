package com.soufianesaadouni.sams

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ListTile() {
    val title = "Item -1"

    var isExpanded by remember {
        mutableStateOf(false)
    }

    /*
    var isDialogOpened by remember {
        mutableStateOf(true)
    }
    */

    Box() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            Text(text = title)
            IconButton(onClick = {
                /*TODO*/
                isExpanded = !isExpanded
            }) {
                Icon(
                    Icons.Filled.MoreVert,
                    tint = Color.Black,
                    contentDescription = "More options",
                )
            }
            DropdownMenu(expanded = isExpanded, onDismissRequest = { /*TODO*/
                isExpanded = false
            }) {
                DropdownMenuItem(
                    text = { Text("Update", color = Color.Black) },
                    onClick = { /*TODO*/ })
                DropdownMenuItem(
                    text = { Text("Delete", color = Color.Black) },
                    onClick = { /*TODO*/ })
                Divider()
                DropdownMenuItem(
                    text = { Text("Info", color = Color.Black) },
                    onClick = { /*TODO*/
                    })
            }
        }
    }
}