package com.objectify.assignment.assignmentapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.objectify.assignment.assignmentapp.ui.theme.BodyM
import com.objectify.assignment.assignmentapp.ui.theme.ContentOnNeutralLow
import com.objectify.assignment.assignmentapp.ui.theme.ContentOnNeutralMedium
import com.objectify.assignment.assignmentapp.ui.theme.ContentOnNeutralXXHigh
import com.objectify.assignment.assignmentapp.ui.theme.LabelM
import com.objectify.assignment.assignmentapp.ui.theme.LabelS
import com.objectify.assignment.assignmentapp.ui.theme.RadiusInput
import com.objectify.assignment.assignmentapp.ui.theme.SurfaceBrand
import com.objectify.assignment.assignmentapp.ui.theme.SurfaceDanger
import com.objectify.assignment.assignmentapp.ui.theme.SurfaceXHigh
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close

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
    helperText: String? = null,
    showClearIcon: Boolean = false
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            label = label?.let { { Text(it, style = LabelM, color = ContentOnNeutralXXHigh) } },
            placeholder = placeholder?.let {
                {
                    Text(it,
                        style = BodyM,
                        color = ContentOnNeutralMedium)
                }
            },
            isError = isError,
            enabled = enabled,
            leadingIcon = leadingIcon,
            trailingIcon = if (showClearIcon && value.isNotEmpty()) {
                {
                    androidx.compose.material3.IconButton(onClick = { onValueChange("") }) {
                        androidx.compose.material3.Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Clear input"
                        )
                    }
                }
            } else trailingIcon,
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            singleLine = true,
            shape = RoundedCornerShape(RadiusInput),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = SurfaceBrand,
                unfocusedBorderColor = SurfaceXHigh,
                errorBorderColor = SurfaceDanger,
                disabledBorderColor = SurfaceXHigh,
                focusedLabelColor = SurfaceBrand,
                unfocusedLabelColor = ContentOnNeutralMedium,
                errorLabelColor = SurfaceDanger,
                cursorColor = SurfaceBrand,
                errorCursorColor = SurfaceDanger,
                focusedTextColor = ContentOnNeutralXXHigh,
                unfocusedTextColor = ContentOnNeutralXXHigh,
                disabledTextColor = ContentOnNeutralLow,
                errorTextColor = SurfaceDanger,
                focusedPlaceholderColor = ContentOnNeutralMedium,
                unfocusedPlaceholderColor = ContentOnNeutralMedium,
                disabledPlaceholderColor = ContentOnNeutralLow
            )
        )
        if (isError && errorText != null) Text(
            text = errorText,
            color = SurfaceDanger,
            style = LabelS,
            modifier = Modifier
        ) else if (helperText != null) Text(
            text = helperText,
            color = ContentOnNeutralMedium,
            style = LabelS,
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