package com.soufianesaadouni.sams

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph
import androidx.navigation.Navigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.soufianesaadouni.sams.ui.theme.SAMSTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SAMSTheme {
                Text(text = "Hello, World!", color = Color.White)
                // A surface container using the 'background' color from the theme
                /*
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
                */
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    View1()
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun View0() {
    var emailText by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var passwordText by remember {
        mutableStateOf(TextFieldValue(""))
    }
    SAMSTheme {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Log In", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Spacer(modifier = Modifier.size(24.dp))
                TextField(
                    value = emailText,
                    onValueChange = { emailText = it },
                    label = { Text("Email") },
                    placeholder = { Text("Enter your email here") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Email,
                            tint = Color.Black,
                            contentDescription = "More options",
                        )
                    },
                )
                TextField(value = passwordText,
                    onValueChange = { passwordText = it },
                    label = { Text("Password") },
                    placeholder = { Text("Enter your password here") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Email,
                            tint = Color.Black,
                            contentDescription = "More options",
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                Icons.Filled.Phone,
                                tint = Color.Black,
                                contentDescription = "More options",
                            )
                        }
                    })
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                ) {
                    Text(
                        "Forgot Password?",
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.padding(4.dp)
                    )
                }
                //Spacer(modifier = Modifier.size(24.dp))
                Button(onClick = { /*TODO*/ }) {
                    Text("Log In", modifier = Modifier.padding(4.dp))
                }
                Text("- - - OR - - -", color = Color.DarkGray)
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Text(text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append("Don't have an account? ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Blue,
                                textDecoration = TextDecoration.Underline,
                            )
                        ) {
                            append("Sign Up")
                        }
                    })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun View1() {
    var itemsList = arrayOf("item1", "item2", "item3")
    var isMenuExpanded by remember {
        mutableStateOf(true)
    }
    SAMSTheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    colors = topAppBarColors(
                        containerColor = Color.DarkGray,
                        /*
                        scrolledContainerColor = MaterialTheme.colorScheme.applyTonalElevation(
                        backgroundColor = Color.Gray,
                        elevation = 4.dp
                        )
                        */
                    ),
                    title = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Title Here", color = Color.White)
                            Text(text = "something here", color = Color.White)
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
                                tint = Color.White,
                                contentDescription = "More options",
                            )
                        }
                    },
                    /*
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                Icons.Filled.back,
                                tint = Color.White,
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
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Hello, World!", fontWeight = FontWeight.Bold, fontSize = 36.sp)
                }

            },
            floatingActionButtonPosition = FabPosition.Center,
            floatingActionButton = {
                FloatingActionButton(containerColor = Color.Yellow, onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Add,
                        tint = Color.Black,
                        contentDescription = "More options",
                    )
                }
            },
        )
        /*
        {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {

            }
        }*/
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun View2() {
    var currentTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Tab1", "Tab2", "Tab3")

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    SAMSTheme {

        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
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
                        0 -> Text("PAGE-0")
                        1 -> Text("PAGE-1")
                        2 -> Text("PAGE-2")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun View3() {
    var switchValue: Boolean by remember {
        mutableStateOf(true)
    }
    SAMSTheme {
        Scaffold(topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.DarkGray,
                    /*
                    scrolledContainerColor = MaterialTheme.colorScheme.applyTonalElevation(
                    backgroundColor = Color.Gray,
                    elevation = 4.dp
                    )*/
                ),
                title = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Settings", color = Color.White)
                    }

                },
                /*
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Filled.MoreVert,
                            tint = Color.White,
                            contentDescription = "More options",
                        )
                    }
                },*/
                /*
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Filled.back,
                            tint = Color.White,
                            contentDescription = "More options",
                        )
                    }
                }*/
            )

        }, content = {
            it
            Box(
                modifier = Modifier.padding(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(text = "Item 1", modifier = Modifier.padding(16.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(text = "Item 1", modifier = Modifier.padding(16.dp))
                        Switch(checked = switchValue,
                            onCheckedChange = { switchValue = !switchValue })
                    }
                }
            }
        }

        )
        /*
        {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {

            }
        }*/
    }

}

@Composable
fun ListTest() {
    val itemsCount = 10

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
                Text(
                    "ITEM -> $iteration", modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

