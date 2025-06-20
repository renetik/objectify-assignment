package com.objectify.assignment.assignmentapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val colorScheme = lightColorScheme(
    primary = SurfaceBrand,
    onPrimary = SurfaceXLow,
    secondary = SurfaceXHigh,
    onSecondary = SurfaceXLow,
    error = SurfaceDanger,
    onError = SurfaceXLow,
    background = SurfaceXLow,
    onBackground = ContentOnNeutralXXHigh,
    surface = SurfaceXLow,
    onSurface = ContentOnNeutralXXHigh,
)

@Composable
fun AppTheme(content: @Composable () -> Unit) = MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
)