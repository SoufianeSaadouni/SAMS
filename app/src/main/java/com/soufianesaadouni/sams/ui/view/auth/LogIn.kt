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

@Preview(showBackground = true)
@Composable
fun LogIn(
    navController: NavHostController = rememberNavController()
) {
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
                Text(
                    text = "Log In",
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp,
                    color = Color.Blue
                )
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
                Button(onClick = { /*TODO*/
                    navController.navigate("classes")
                }) {
                    Text("Log In", modifier = Modifier.padding(4.dp))
                }
                Text(
                    "- - - OR - - -",
                    color = Color.DarkGray,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Button(
                    onClick = { /*TODO*/
                        navController.navigate("signUp")
                    },
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