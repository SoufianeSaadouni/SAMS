package com.soufianesaadouni.sams.ui.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.soufianesaadouni.sams.ui.view.attendance.Attendance
import com.soufianesaadouni.sams.ui.view.auth.LogIn
import com.soufianesaadouni.sams.ui.view.auth.SignUp
import com.soufianesaadouni.sams.ui.viewmodel.StudentViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    // TODO pass this as parameter to children
    NavHost(navController = navController, startDestination = "logIn") {
        composable(route = "logIn") {
            LogIn(navController)
        }
        composable(route = "signUp") {
            SignUp(navController)
        }
        composable(route = "classes") {
            Classes(navController)
        }
        composable(route = "attendance") {
            Attendance()
        }
        composable(route = "settings") {
            Settings()
        }
    }
}