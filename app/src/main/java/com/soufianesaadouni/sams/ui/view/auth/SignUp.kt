package com.soufianesaadouni.sams.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.soufianesaadouni.sams.ui.theme.SAMSTheme
import com.soufianesaadouni.sams.ui.viewmodel.TeacherViewModel

@Preview(showBackground = true)
@Composable
fun SignUp(
    navController: NavHostController = rememberNavController()
) {
    val teacherViewModel = TeacherViewModel()
    var fullName by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var email by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var password by remember {
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
                Text(
                    text = "Sign Up", fontWeight = FontWeight.Bold, fontSize = 36.sp,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.size(24.dp))
                TextField(
                    value = fullName,
                    onValueChange = { fullName = it },
                    label = { Text("Full Name") },
                    placeholder = { Text("Enter your full name here") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Email,
                            tint = Color.Black,
                            contentDescription = "More options",
                        )
                    },
                )
                TextField(
                    value = email,
                    onValueChange = { email = it },
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
                TextField(value = password,
                    onValueChange = { password = it },
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
                Spacer(modifier = Modifier.size(8.dp))
                Button(onClick = { /*TODO*/
                    teacherViewModel.createTeacher(email.text, password.text)
                    navController.navigate("classes")
                }) {
                    Text("Sign Up", modifier = Modifier.padding(4.dp))
                }
                Text("- - - OR - - -", color = Color.DarkGray)
                Button(
                    onClick = { /*TODO*/
                        navController.navigate("logIn")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Text(text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append("Already have an account? ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Blue,
                                textDecoration = TextDecoration.Underline,
                            )
                        ) {
                            append("Log In")
                        }
                    })
                }
            }
        }
    }
}