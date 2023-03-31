package com.soufianesaadouni.sams

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "logIn") {
        composable(route = "logIn") {
            LogIn(navController)
        }
        composable(route = "signUp") {
            SignUp(navController)
        }
        composable(route = "classes") {
            Classes()
        }
        composable(route = "attendance") {
            Attendance()
        }
        composable(route = "settings") {
            Settings()
        }
    }
}