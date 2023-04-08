package com.soufianesaadouni.sams.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ListTile(
    title: String = "Item",
    onclick: () -> Unit = {},
    onUpdateClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {},
    onInfoClick: () -> Unit = {},
) {
    val (isMenuExpanded, setIsMenuExpanded) = remember {
        mutableStateOf(false)
    }

    /*
    var isDialogOpened by remember {
        mutableStateOf(true)
    }
    */

    TextButton(
        onClick = onclick, shape = ShapeDefaults.ExtraLarge, border = BorderStroke(
            0.dp, Color.Transparent
        ), colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Box {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                //.padding(horizontal = 16.dp),
            ) {
                Text(text = title, color = Color.Black)
                Column {
                    Box(modifier = Modifier.padding(0.dp)) {
                        IconButton(onClick = {
                            /*TODO*/
                            setIsMenuExpanded(!isMenuExpanded)
                        }) {
                            Icon(
                                Icons.Filled.MoreVert,
                                tint = Color.Black,
                                contentDescription = "More options",
                            )
                        }
                        DropdownMenu(expanded = isMenuExpanded, onDismissRequest = { /*TODO*/
                            setIsMenuExpanded(false)
                        }) {
                            DropdownMenuItem(
                                text = { Text("Update", color = Color.Black) },
                                onClick = onUpdateClick
                            )
                            DropdownMenuItem(
                                text = { Text("Delete", color = Color.Black) },
                                onClick = onDeleteClick
                            )
                            Divider()
                            DropdownMenuItem(
                                text = { Text("Info", color = Color.Black) },
                                onClick = onInfoClick
                            )
                        }
                    }
                }
            }
        }
    }
}