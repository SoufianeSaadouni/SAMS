package com.soufianesaadouni.sams.ui.view.attendance

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.soufianesaadouni.sams.ui.theme.SAMSTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Attendance(navController: NavHostController = rememberNavController(), arg1: String? = "") {
    var currentTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Students", "Attendance", "Statistics")

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val itemsList = arrayOf("Export", "Print")
    var isMenuExpanded by remember {
        mutableStateOf(true)
    }

    SAMSTheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Attendance Management")
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
                    /*
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                Icons.Filled.back,

                                contentDescription = "More options",
                            )
                        }
                    }*/
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
                                    selected = currentTabIndex == index, onClick = { /*TODO*/
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
                            pageCount = 3,
                            state = pagerState,
                            beyondBoundsPageCount = 3,
                            pageSize = PageSize.Fill,
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.0.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                when (currentTabIndex) {
                                    0 -> StudentsTab()
                                    1 -> AttendanceTab()
                                    2 -> StatisticsTab()
                                }
                            }
                        }
                    }
                }
            },
        )
    }
}
