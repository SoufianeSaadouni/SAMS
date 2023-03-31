package com.soufianesaadouni.sams

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soufianesaadouni.sams.ui.theme.SAMSTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Classes() {
    val itemsCount = 15

    val itemsList = arrayOf("Rate", "Share", "Exit")
    var isMenuExpanded by remember {
        mutableStateOf(true)
    }

    SAMSTheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(),
                    title = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Classes")
                        }
                    },
                    actions = {

                        DropdownMenu(expanded = isMenuExpanded, onDismissRequest = { /*TODO*/ }) {
                            itemsList.forEachIndexed { _, title ->
                                DropdownMenuItem(text = { Text(title) }, onClick = {
                                    isMenuExpanded = !isMenuExpanded
                                })
                            }
                        }
                        IconButton(onClick = {
                            isMenuExpanded = !isMenuExpanded
                        }) {
                            Icon(
                                Icons.Filled.MoreVert,
                                contentDescription = "More options",
                            )
                        }
                    },
                )
            },
            content = {
                it
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        repeat(itemsCount) { iteration ->
                            Box(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .clip(CircleShape)
                                    .align(Alignment.CenterHorizontally)
                                    .fillMaxWidth()
                            ) {

                                ListTile()
                            }
                        }
                    }

                }

            },
            //floatingActionButtonPosition = FabPosition.Center,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "More options",
                    )
                }
            },
        )
    }
}