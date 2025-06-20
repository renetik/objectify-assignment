package com.objectify.assignment.assignmentapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.objectify.assignment.assignmentapp.ui.InputView
import com.objectify.assignment.assignmentapp.ui.PasswordInput
import com.objectify.assignment.assignmentapp.ui.theme.AssignmentAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssignmentAppTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackbarHostState) }
                ) { innerPadding ->
                    LoginScreen(
                        modifier = Modifier.padding(innerPadding),
                        snackbarHostState = snackbarHostState
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier, snackbarHostState: SnackbarHostState) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var isLoggingIn by remember { mutableStateOf(false) }
    var showSnackbar by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InputView(
            value = username,
            onValueChange = { username = it },
            label = "Username",
            placeholder = "Enter your username",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        PasswordInput(
            password = password,
            onPasswordChange = { password = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { showSnackbar = true },
            enabled = username.isNotBlank() && password.isNotBlank() && !isLoggingIn,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
    }

    if (showSnackbar) {
        LaunchedEffect(showSnackbar) {
            snackbarHostState.showSnackbar("Username: $username\nPassword: $password")
            showSnackbar = false
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AssignmentAppTheme {
        val snackbarHostState = remember { SnackbarHostState() }
        LoginScreen(snackbarHostState = snackbarHostState)
    }
}