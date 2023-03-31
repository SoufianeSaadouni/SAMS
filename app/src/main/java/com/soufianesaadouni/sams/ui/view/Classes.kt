package com.soufianesaadouni.sams.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.soufianesaadouni.sams.data.model.Classe
import com.soufianesaadouni.sams.data.repository.ClasseRepository
import com.soufianesaadouni.sams.ui.theme.SAMSTheme
import com.soufianesaadouni.sams.ui.viewmodel.ClasseViewModel
import com.soufianesaadouni.sams.ui.viewmodel.TeacherViewModel
import kotlinx.coroutines.launch
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Classes(navController: NavHostController = rememberNavController()) {
    val teacherViewModel = TeacherViewModel()
    val classeRepository =
        ClasseRepository(FirebaseFirestore.getInstance(), FirebaseAuth.getInstance())
    val classeViewModel = ClasseViewModel(classeRepository)

    val students by classeViewModel
        .classes
        .collectAsState(initial = emptyList())

    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    var classeName by remember {
        mutableStateOf(TextFieldValue(""))
    }


    val itemsList = arrayOf("Rate", "Share", "Exit")
    val (isMenuExpanded, setIsMenuExpanded) = remember {
        mutableStateOf(false)
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

                            //TODO Sign out
                            teacherViewModel.signOut()
                            navController.navigate("logIn") {
                                // To remove this composable from the stack
                                popUpTo("classes") {
                                    inclusive = true
                                }
                            }
                        }) {
                            Icon(
                                Icons.Filled.Phone,
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
                    ListTile(students[index]!!.name)
                }
                /*
                repeat(itemsCount) { iteration ->
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(CircleShape)
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth()
                    ) {


                    }
                }*/
            }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        classeViewModel.add(Classe("CLASSE 1998"))
                        /*
                        coroutineScope.launch {
                            sheetState.show()
                        }*/
                    }) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "More options",
                    )
                }
            },
        )
/*
        ModalBottomSheet(sheetState = sheetState, onDismissRequest = {
            coroutineScope.launch {
                sheetState.hide()
            }
        }) {
            Column {
                TextField(
                    value = classeName,
                    onValueChange = { classeName = it },
                    label = { Text("Classe Name") },
                    placeholder = { Text("Enter your classe name here") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                )
                Spacer(modifier = Modifier.size(24.dp))
                Button(onClick = {
                    classeViewModel.add(classe = Classe(classeName.text))
                    coroutineScope.launch {
                        sheetState.hide()
                    }
                }) {
                    Text("Save")
                }
                Spacer(modifier = Modifier.size(24.dp))
            }
        }*/
    }
}