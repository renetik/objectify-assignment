package com.objectify.assignment.assignmentapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InputView(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    isError: Boolean = false,
    errorText: String? = null,
    enabled: Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    helperText: String? = null
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            label = label?.let { { Text(it) } },
            placeholder = placeholder?.let { { Text(it) } },
            isError = isError,
            enabled = enabled,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            singleLine = true
        )
        if (isError && errorText != null) Text(
            text = errorText,
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
        ) else if (helperText != null) Text(
            text = helperText,
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
        )
    }
}

@Composable
@Preview(showBackground = true, name = "InputView - Normal")
fun PreviewInputViewNormal() {
    var text by remember { mutableStateOf("") }
    InputView(
        value = text,
        onValueChange = { text = it },
        label = "Username",
        placeholder = "Enter your username",
        helperText = "This is a helper text"
    )
}

@Composable
@Preview(showBackground = true, name = "InputView - Error")
fun PreviewInputViewError() {
    var text by remember { mutableStateOf("") }
    InputView(
        value = text,
        onValueChange = { text = it },
        label = "Email",
        placeholder = "Enter your email",
        isError = true,
        errorText = "Invalid email address"
    )
} 