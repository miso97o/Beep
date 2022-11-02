package com.example.beep.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.beep.ui.home.HomeScreen
import com.example.beep.ui.message.MessageScreen
import com.example.beep.ui.message.MessageViewModel
import com.example.beep.ui.mypage.MyPageScreen

@Composable
fun BeepNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("chat") {
            val model: MessageViewModel = hiltViewModel(it)
            MessageScreen(model)
        }
        composable("settings") {
            MyPageScreen()
        }
    }
}