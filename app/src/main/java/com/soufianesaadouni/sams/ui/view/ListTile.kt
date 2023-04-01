package com.soufianesaadouni.sams.ui.view

import androidx.compose.foundation.BorderStroke
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.soufianesaadouni.sams.utils.RouteDestinations

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ListTile(
    navController: NavHostController = rememberNavController(),
    title: String = "Item -1"
) {
    val (isMenuExpanded, setIsMenuExpanded) = remember {
        mutableStateOf(false)
    }

    /*
    var isDialogOpened by remember {
        mutableStateOf(true)
    }
    */

    Button(
        onClick = { /*TODO delete later*/
            navController.navigate("attendance")
        }, shape = ShapeDefaults.ExtraLarge, border = BorderStroke(
            0.dp, Color.LightGray
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
                    .padding(horizontal = 16.dp),
            ) {
                Text(text = title)
                Column {
                    Box {
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
                            DropdownMenuItem(text = { Text("Update", color = Color.Black) },
                                onClick = { /*TODO*/ })
                            DropdownMenuItem(text = { Text("Delete", color = Color.Black) },
                                onClick = { /*TODO*/ })
                            Divider()
                            DropdownMenuItem(text = { Text("Info", color = Color.Black) },
                                onClick = { /*TODO*/
                                })
                        }
                    }
                }
            }
        }
    }
}