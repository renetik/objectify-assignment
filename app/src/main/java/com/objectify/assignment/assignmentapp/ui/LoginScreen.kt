package com.objectify.assignment.assignmentapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.objectify.assignment.assignmentapp.R
import com.objectify.assignment.assignmentapp.ui.components.InputView
import com.objectify.assignment.assignmentapp.ui.components.PasswordInput
import com.objectify.assignment.assignmentapp.ui.theme.AppTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState
) {
    val focusManager = LocalFocusManager.current
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var showSnackbar by rememberSaveable { mutableStateOf(false) }
    val passwordValid = password.isPasswordValid()
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .widthIn(max = 400.dp)
                .wrapContentWidth()
                .verticalScroll(rememberScrollState())
                .imePadding()
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputView(
                value = username,
                onValueChange = { username = it },
                label = stringResource(R.string.input_label_username),
                placeholder = stringResource(R.string.input_placeholder_username),
                modifier = Modifier.fillMaxWidth(),
                showClearIcon = true
            )
            Spacer(Modifier.height(16.dp))
            PasswordInput(
                password = password,
                onPasswordChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                showClearIcon = true
            )
            Spacer(Modifier.height(24.dp))
            Button(
                onClick = {
                    focusManager.clearFocus(true)
                    showSnackbar = true
                },
                enabled = username.isNotBlank() && passwordValid,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.login_button))
            }
        }
    }
    if (showSnackbar) {
        val message = stringResource(R.string.login_snackbar, username, password)
        LaunchedEffect(Unit) {
            snackbarHostState.showSnackbar(message)
            showSnackbar = false
        }
    }
}

private fun String.isPasswordValid(): Boolean =
    listOf(length >= 8, any { it.isUpperCase() },
        any { it.isDigit() }, any { it in "?=#/%" }).all { it }

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() = AppTheme {
    val snackbarHostState = remember { SnackbarHostState() }
    LoginScreen(snackbarHostState = snackbarHostState)
}