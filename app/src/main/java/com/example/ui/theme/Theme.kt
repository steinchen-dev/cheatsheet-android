package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Erweiterte Design-Token für den Glassmorphismus-Look
 */
@Immutable
data class GlassColors(
    val cardBackground: Color,
    val cardBorderTopLeft: Color,
    val cardBorderBottomRight: Color,
    val innerHighlight: Color,
    val searchBarBackground: Color,
    val searchBarBorder: Color,
    val drawerBackground: Color,
    val badgeBackground: Color,
    val badgeContent: Color
)

val LocalGlassColors = staticCompositionLocalOf {
    GlassColors(
        cardBackground = DarkPetrolSurface.copy(alpha = 0.65f),
        cardBorderTopLeft = Color.White.copy(alpha = 0.35f),
        cardBorderBottomRight = MutedSlateTeal.copy(alpha = 0.15f),
        innerHighlight = Color.White.copy(alpha = 0.08f),
        searchBarBackground = DarkPetrolSurface.copy(alpha = 0.50f),
        searchBarBorder = MutedSlateTeal.copy(alpha = 0.35f),
        drawerBackground = DarkPetrolSurface.copy(alpha = 0.88f),
        badgeBackground = DarkPetrolSurface.copy(alpha = 0.70f),
        badgeContent = LightIceGray
    )
}

@Composable
fun CheatSheetTheme(
    darkTheme: Boolean = true,
    accentColor: Color = SoftSeafoamCyan,
    textScaleFactor: Float = 1.0f,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        darkColorScheme(
            primary = accentColor,
            onPrimary = MidnightDarkBackground,
            primaryContainer = DarkPetrolSurface,
            onPrimaryContainer = LightIceGray,
            secondary = MutedSlateTeal,
            onSecondary = LightIceGray,
            background = MidnightDarkBackground,
            onBackground = LightIceGray,
            surface = DarkPetrolSurface,
            onSurface = LightIceGray,
            surfaceVariant = DarkPetrolSurface.copy(alpha = 0.75f),
            onSurfaceVariant = LightIceGray.copy(alpha = 0.85f),
            outline = MutedSlateTeal.copy(alpha = 0.40f)
        )
    } else {
        lightColorScheme(
            primary = accentColor,
            onPrimary = Color.White,
            primaryContainer = Color.White,
            onPrimaryContainer = DarkTextPrimary,
            secondary = MutedSlateTeal,
            onSecondary = Color.White,
            background = LightBackground,
            onBackground = DarkTextPrimary,
            surface = Color.White,
            onSurface = DarkTextPrimary,
            surfaceVariant = LightSurface,
            onSurfaceVariant = DarkTextSecondary,
            outline = MutedSlateTeal.copy(alpha = 0.35f)
        )
    }

    val glassColors = if (darkTheme) {
        GlassColors(
            cardBackground = DarkPetrolSurface.copy(alpha = 0.60f),
            cardBorderTopLeft = Color.White.copy(alpha = 0.28f),
            cardBorderBottomRight = accentColor.copy(alpha = 0.12f),
            innerHighlight = Color.White.copy(alpha = 0.06f),
            searchBarBackground = DarkPetrolSurface.copy(alpha = 0.50f),
            searchBarBorder = MutedSlateTeal.copy(alpha = 0.35f),
            drawerBackground = DarkPetrolSurface.copy(alpha = 0.85f),
            badgeBackground = DarkPetrolSurface.copy(alpha = 0.75f),
            badgeContent = LightIceGray
        )
    } else {
        GlassColors(
            cardBackground = Color.White.copy(alpha = 0.72f),
            cardBorderTopLeft = Color.White.copy(alpha = 0.90f),
            cardBorderBottomRight = accentColor.copy(alpha = 0.20f),
            innerHighlight = Color.White.copy(alpha = 0.40f),
            searchBarBackground = Color.White.copy(alpha = 0.70f),
            searchBarBorder = MutedSlateTeal.copy(alpha = 0.25f),
            drawerBackground = Color.White.copy(alpha = 0.92f),
            badgeBackground = Color.White.copy(alpha = 0.85f),
            badgeContent = DarkTextPrimary
        )
    }

    val typography = getScaledTypography(textScaleFactor)

    CompositionLocalProvider(
        LocalGlassColors provides glassColors,
        LocalTextScale provides textScaleFactor
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }
}
