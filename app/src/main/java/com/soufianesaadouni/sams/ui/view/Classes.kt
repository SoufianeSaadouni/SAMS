package com.soufianesaadouni.sams.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.soufianesaadouni.sams.data.model.Classe
import com.soufianesaadouni.sams.data.repository.ClasseRepository
import com.soufianesaadouni.sams.ui.view.dialogs.AddClasse
import com.soufianesaadouni.sams.ui.viewmodel.ClasseViewModel
import com.soufianesaadouni.sams.ui.viewmodel.TeacherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Classes(navController: NavHostController = rememberNavController()) {
    val teacherViewModel = TeacherViewModel()
    val classeRepository =
        ClasseRepository(FirebaseFirestore.getInstance(), FirebaseAuth.getInstance())
    val classeViewModel = ClasseViewModel(classeRepository)
    classeViewModel.fetch()

    val students by classeViewModel
        .classes
        .collectAsState(/*initial = emptyList()*/)

    var openBottomSheet by rememberSaveable {
        mutableStateOf(false)
    }

    var isDialogShown by remember { mutableStateOf(false) }

    val itemsList = arrayOf("Rate", "Share", "Exit")
    val (isMenuExpanded, setIsMenuExpanded) = remember {
        mutableStateOf(false)
    }

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

                    DropdownMenu(
                        expanded = isMenuExpanded,
                        onDismissRequest = {
                            setIsMenuExpanded(!isMenuExpanded)
                        }) {
                        itemsList.forEachIndexed { _, title ->
                            DropdownMenuItem(text = { Text(title) }, onClick = {
                                setIsMenuExpanded(!isMenuExpanded)
                            })
                        }
                    }
                    IconButton(onClick = {
                        setIsMenuExpanded(!isMenuExpanded)

                    }) {
                        Icon(
                            Icons.Filled.MoreVert,
                            contentDescription = "More options",
                        )
                    }

                    IconButton(onClick = {
                        teacherViewModel.signOut()
                        navController.navigate("logIn") {
                            // To remove this composable from the stack
                            popUpTo("classes") {
                                inclusive = true
                            }
                        }
                    }) {
                        Icon(
                            Icons.Filled.ExitToApp,
                            contentDescription = "Sign out",
                        )
                    }
                },
            )
        },
        content = {
            it
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(students.size) { index ->
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        ListTile(
                            students[index]!!.name,
                            onclick = {
                                val classeID = students[index]!!.id
                                navController.navigate("attendance/${classeID}")
                            })
                    }
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    isDialogShown = true
                }) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "More options",
                )
            }
        },
    )

    // Display Dialog
    if (isDialogShown) {
        AddClasse(onSaveClick = {
            classeViewModel.add(classe = Classe(name = it))
            isDialogShown = false
        }, onDismiss = {
            isDialogShown = false
        })
    }
}