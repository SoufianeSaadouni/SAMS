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
import com.soufianesaadouni.sams.ui.viewmodel.TeacherViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    // TODO pass this as parameter to children

    val startDestination: String

    val teacherViewModel = TeacherViewModel()
    startDestination = if (teacherViewModel.isUserSignedIn) {
        "classes"
    } else {
        "logIn"
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = "logIn") {
            LogIn(navController)
        }
        composable(route = "signUp") {
            SignUp(navController)
        }
        composable(route = "classes") {
            Classes(navController)
        }
        composable(
            route = "attendance/{classeID}",
            arguments = listOf(
                navArgument(
                    "classeID",
                ) {
                    type = NavType.StringType
                })
        ) { navBackStackEntry ->
            val classeID = navBackStackEntry.arguments?.getString("classeID") ?: "Empty!"
            Attendance(navController, classeID)
        }
        composable(route = "settings") {
            Settings()
        }
    }
}