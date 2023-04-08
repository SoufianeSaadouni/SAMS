package com.soufianesaadouni.sams.ui.view.attendance

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.soufianesaadouni.sams.data.repository.ClasseRepository
import com.soufianesaadouni.sams.ui.theme.SAMSTheme
import com.soufianesaadouni.sams.ui.viewmodel.ClasseViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Attendance(navController: NavHostController = rememberNavController(), classeID: String? = "") {
    //Log.d("Attendance", "Attendance: $classeID")
    // Toast.makeText(LocalContext.current, "Attendance: $classeID", Toast.LENGTH_LONG).show()

    val pageCount = 3
    var currentTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Students", "Attendance", "Statistics")

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val itemsList = arrayOf("Export", "Print")
    var isMenuExpanded by remember {
        mutableStateOf(false)
    }

    val items = ClasseViewModel(
        ClasseRepository(
            FirebaseFirestore.getInstance(),
            FirebaseAuth.getInstance(),
        )
    )
    items.fetch()

    /*
    var isClassesMenuExpanded by remember {
        mutableStateOf(false)
    }*/


    SAMSTheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Box {
                            Column {
                                Text(text = "Attendance Management")
                                /*
                                TextButton(onClick = {
                                    isClassesMenuExpanded = !isClassesMenuExpanded
                                }) {
                                }
                                DropdownMenu(
                                    expanded = isClassesMenuExpanded,
                                    onDismissRequest = { /*TODO*/
                                        isClassesMenuExpanded = false
                                    }) {
                                    items.classes.collectAsState().value.forEach {
                                        DropdownMenuItem(
                                            text = { Text(it!!.name) },
                                            onClick = {
                                                isClassesMenuExpanded
                                            })
                                    }
                                }*/
                            }
                        }
                    },
                    actions = {
                        Box {
                            Column {
                                IconButton(onClick = {
                                    isMenuExpanded = !isMenuExpanded
                                }) {
                                    Icon(
                                        Icons.Filled.MoreVert,
                                        contentDescription = "More options",
                                    )
                                }
                                DropdownMenu(
                                    expanded = isMenuExpanded,
                                    onDismissRequest = { /*TODO*/
                                        isMenuExpanded = false
                                    }) {
                                    itemsList.forEachIndexed { _, title ->
                                        DropdownMenuItem(
                                            text = { Text(title) },
                                            onClick = {
                                                isMenuExpanded = false
                                            })
                                    }
                                }
                            }
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigate("Classes") {
                                popUpTo("Classes") {
                                    inclusive = true
                                }
                            }
                        }) {
                            Icon(
                                Icons.Filled.ArrowBack,
                                contentDescription = "More options",
                            )
                        }
                    }
                )
            },
            content = {
                it
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TabRow(selectedTabIndex = currentTabIndex) {
                            tabs.forEachIndexed { index, title ->
                                Tab(
                                    selected = currentTabIndex == index, onClick = {
                                        currentTabIndex = index
                                        coroutineScope.launch {
                                            // Scrolling to a page
                                            pagerState.animateScrollToPage(index)
                                        }
                                    }, modifier = Modifier.padding(12.dp)
                                ) {
                                    Text(title)
                                }
                            }
                        }
                        HorizontalPager(
                            pageCount = pageCount,
                            state = pagerState,
                            pageSize = PageSize.Fill,
                            beyondBoundsPageCount = 0,
                            pageContent = { page ->
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.0.dp),
                                    contentAlignment = Alignment.Center
                                ) {


                                    when (page) {
                                        0 -> StudentsTab()
                                        1 -> AttendanceTab()
                                        2 -> StatisticsTab()
                                        //currentTabIndex = page
                                    }
                                }
                            }
                        )
                    }
                }
            },
        )
    }
}
