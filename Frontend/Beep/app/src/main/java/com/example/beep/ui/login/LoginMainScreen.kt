package com.example.beep.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.beep.ui.navigation.NavGraph
import kotlinx.coroutines.launch

@Composable
fun LoginMainScreen() {
    val navController = rememberNavController()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        NavGraph(navController = navController)
        login_main()
    }
}

@Composable
fun login_main() {
    val vm = UserState.current
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0XFFF5F8FF)
            )
    ) {

        Column(
            Modifier
                .fillMaxSize()
                .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                coroutineScope.launch {
                    vm.signIn(email= "1234", password = "1234")
                }
            }){
                Text(text = "로그인")
            }

            Button(onClick = {
                coroutineScope.launch {
                    vm.signOut()
                }
            }) {
                Text(text = "로그아웃")
            }
            
            Button(onClick = { }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "로그인")
            }

            Button(onClick = { }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "회원가입")
            }


        }
    }
}
