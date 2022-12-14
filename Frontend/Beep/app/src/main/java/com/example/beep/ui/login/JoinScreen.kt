package com.example.beep.ui.login

import android.util.Log
import android.widget.Toast
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.beep.di.MainApplication

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun JoinScreen(navController: NavController) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val viewModel = viewModel<UserViewModel>()
    val state = viewModel.authState
    val loginState = viewModel.loginState
    val context = LocalContext.current
    val token = MainApplication.sharedPreferencesUtil.getToken()

    LaunchedEffect(loginState.isUserLoggedIn) {
        Log.d("launchEffect 실행", "$loginState")
        if (token != null) {
            if (token.isNotBlank()) {
                navController.navigate("beep_graph") {
                    popUpTo("login_graph") {
                        inclusive = true
                    }
                }
            }
        }
    }

    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is UserViewModel.ValidationEvent.Success -> {
                    Toast.makeText(
                        context,
                        "successful",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(
                color = Color(0XFFF5F8FF)
            )
            .clickable { keyboardController?.hide() },
    ) {

        Column(
            Modifier
                .fillMaxSize()
                .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = state.phoneNumber,
                onValueChange = {
                    viewModel.onEvent(AuthFormEvent.PhoneNumberChanged(it))
                },
                isError = state.phoneNumberError != null,
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "휴대폰 번호")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(android.graphics.Color.parseColor("#7AA8FF")),
                    unfocusedBorderColor = Color(android.graphics.Color.parseColor("#9DBFFF"))
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )
            if (state.phoneNumberError != null) {
                Text(
                    text = state.phoneNumberError,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center

                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = state.password,
                onValueChange = {
                    viewModel.onEvent(AuthFormEvent.PasswordChanged(it))
                },
                isError = state.passwordError != null,
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "비밀번호")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(android.graphics.Color.parseColor("#7AA8FF")),
                    unfocusedBorderColor = Color(android.graphics.Color.parseColor("#9DBFFF"))
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                visualTransformation = PasswordVisualTransformation()
            )
            if (state.passwordError != null) {
                Text(
                    text = state.passwordError,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center

                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = state.passwordCheck,
                onValueChange = {
                    viewModel.onEvent(AuthFormEvent.PasswordCheckChanged(it))
                },
                isError = state.passwordCheckError != null,
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "비밀번호 확인")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(android.graphics.Color.parseColor("#7AA8FF")),
                    unfocusedBorderColor = Color(android.graphics.Color.parseColor("#9DBFFF"))
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Go
                ),
                visualTransformation = PasswordVisualTransformation()
            )
            if (state.passwordCheckError != null) {
                Text(
                    text = state.passwordCheckError,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center

                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = state.acceptedTerms,
                    onCheckedChange = {
                        viewModel.onEvent(AuthFormEvent.AcceptTerms(it))
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "휴대폰 번호 활용 동의")
            }

            if (state.termError != null) {
                Text(
                    text = state.termError,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center

                )
            }

            Button(
                onClick = {
                    viewModel.onEvent(AuthFormEvent.Submit)
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "회원가입")
            }

        }

    }
}
