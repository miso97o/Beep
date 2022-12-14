package com.example.beep.ui.navigation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.beep.di.MainApplication
import com.example.beep.ui.BeepApp
import com.example.beep.ui.login.*

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun RootNavGraph(viewModel: UserViewModel = viewModel()) {
    val navController = rememberNavController()
    val token = MainApplication.sharedPreferencesUtil.getToken()
    var isLoggedDestination = "beep_graph"

    if (token != null) {
        if (token.isNotBlank()) {
            isLoggedDestination = "beep_graph"
        }
    }


    NavHost(navController = navController, startDestination = isLoggedDestination) {
        composable("beep_graph") {
            val model: UserViewModel = hiltViewModel(it)
            BeepApp()
        }
        composable("login_graph") {
            val model : UserViewModel = hiltViewModel(it)
            LoginScreen(navController = navController)
        }
        composable("join_graph") {
            val model : UserViewModel = hiltViewModel(it)
            JoinScreen(navController = navController)
        }
    }
}