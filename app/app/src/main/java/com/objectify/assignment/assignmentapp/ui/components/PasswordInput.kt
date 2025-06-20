package com.objectify.assignment.assignmentapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.objectify.assignment.assignmentapp.ui.theme.ContentOnNeutralMedium
import com.objectify.assignment.assignmentapp.ui.theme.LabelS
import com.objectify.assignment.assignmentapp.ui.theme.SpacingXS
import com.objectify.assignment.assignmentapp.ui.theme.SurfaceBrand

private data class PasswordRequirement(val label: String, val isMet: (String) -> Boolean)

/**
 * Password requirements for validation.
 * - At least 8 characters
 * - At least one uppercase letter
 * - At least one digit
 * - At least one special character (? = # / %)
 */
private val passwordRequirements = listOf(
    PasswordRequirement("Minimálne 8 znakov") { it.length >= 8 },
    PasswordRequirement("Aspoň jedno veľké písmeno") { it.any { c -> c.isUpperCase() } },
    PasswordRequirement("Aspoň jedno číslo") { it.any { c -> c.isDigit() } },
    PasswordRequirement("Aspoň jeden špeciálny znak (? = # / %)") { it.any { c -> c in "?=#/%" } }
)

/**
 * A password input field with validation and requirements display.
 *
 * @param password The current password value.
 * @param onPasswordChange Callback when the password changes.
 * @param modifier Modifier to be applied to the input field.
 * @param enabled Whether the input field is enabled for user interaction.
 * @param showClearIcon If true, shows a clear (close) icon when the input is not empty.
 */
@Composable
fun PasswordInput(
    password: String,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    showClearIcon: Boolean = false
) {
    val requirementsStatus = passwordRequirements.map { it.isMet(password) }
    val allValid = requirementsStatus.all { it }

    Column(modifier = modifier) {
        InputView(
            value = password,
            onValueChange = onPasswordChange,
            label = "Heslo",
            placeholder = "Zadajte heslo",
            isError = !allValid && password.isNotEmpty(),
            errorText = if (!allValid && password.isNotEmpty()) "Heslo nespĺňa požiadavky" else null,
            enabled = enabled,
            visualTransformation = PasswordVisualTransformation(),
            showClearIcon = showClearIcon
        )
        Spacer(modifier = Modifier.height(SpacingXS))
        Column {
            passwordRequirements.forEachIndexed { i, req ->
                val met = requirementsStatus[i]
                RequirementRow(label = req.label, met = met)
            }
        }
    }
}

@Composable
private fun RequirementRow(label: String, met: Boolean) {
    val color = if (met) SurfaceBrand else ContentOnNeutralMedium
    val icon = if (met) Icons.Filled.CheckCircle else Icons.Filled.Error
    RowWithIcon(icon = icon, color = color, label = label)
}

@Composable
private fun RowWithIcon(icon: androidx.compose.ui.graphics.vector.ImageVector,
    color: Color,
    label: String) {
    androidx.compose.foundation.layout.Row {
        Icon(imageVector = icon, contentDescription = null, tint = color)
        Spacer(modifier = Modifier.width(SpacingXS))
        Text(text = label, color = color, style = LabelS)
    }
}

/**
 * Preview of PasswordInput.
 */
@Preview(showBackground = true, name = "PasswordInput Preview")
@Composable
fun PreviewPasswordInput() {
    var password by remember { mutableStateOf("") }
    PasswordInput(password = password, onPasswordChange = { password = it })
} 