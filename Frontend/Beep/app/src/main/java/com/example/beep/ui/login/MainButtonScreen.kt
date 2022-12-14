package com.example.beep.ui.login

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.beep.ui.theme.*

@Composable
fun MainButtonScreen(navController: NavController) {
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(visible) {
        if (!visible) {
            visible = true
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .statusBarsPadding()
            .navigationBarsPadding(),
        contentAlignment = Alignment.Center

    ) {
        Column(
            Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "BEEP",
                modifier = Modifier,
                fontSize = 40.sp,
            )
        }
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn() + expandVertically(
                    expandFrom = Alignment.Top,
                animationSpec = tween(2000,1000),
                clip = false
                )
            ,
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(48.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
            ) {
                Button(
                    onClick = { navController.navigate("login_graph") {
                        popUpTo("login_main_graph") {
                            inclusive = true
                        }
                    } },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                ) {
                    Text(text = "시작하기")
                }
                
                Spacer(modifier = Modifier.height(48.dp))
            }
        }
    }
}