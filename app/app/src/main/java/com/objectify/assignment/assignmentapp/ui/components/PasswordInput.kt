package com.objectify.assignment.assignmentapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private data class PasswordRequirement(val label: String, val isMet: (String) -> Boolean)

private val passwordRequirements = listOf(
    PasswordRequirement("Minimálne 8 znakov") { it.length >= 8 },
    PasswordRequirement("Aspoň jedno veľké písmeno") { it.any { c -> c.isUpperCase() } },
    PasswordRequirement("Aspoň jedno číslo") { it.any { c -> c.isDigit() } },
    PasswordRequirement("Aspoň jeden špeciálny znak (? = # / %)") { it.any { c -> c in "?=#/%" } }
)

@Composable
fun PasswordInput(
    password: String,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
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
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(8.dp))
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
    val color = if (met) Color(0xFF4CAF50) else Color.Gray
    val icon = if (met) Icons.Filled.CheckCircle else Icons.Filled.Error
    RowWithIcon(icon = icon, color = color, label = label)
}

@Composable
private fun RowWithIcon(icon: androidx.compose.ui.graphics.vector.ImageVector, color: Color, label: String) {
    androidx.compose.foundation.layout.Row {
        Icon(imageVector = icon, contentDescription = null, tint = color)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label, color = color, style = MaterialTheme.typography.bodySmall)
    }
}

@Preview(showBackground = true, name = "PasswordInput Preview")
@Composable
fun PreviewPasswordInput() {
    var password by remember { mutableStateOf("") }
    PasswordInput(password = password, onPasswordChange = { password = it })
} 