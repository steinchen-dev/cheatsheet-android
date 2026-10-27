package com.example.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Textgrößen-Stufen für den Settings-Drawer
 */
enum class TextScaleLevel(val label: String, val scaleFactor: Float) {
    SMALL("Klein", 0.88f),
    MEDIUM("Mittel", 1.0f),
    LARGE("Groß", 1.16f);

    companion object {
        fun fromFactor(factor: Float): TextScaleLevel {
            return entries.minByOrNull { kotlin.math.abs(it.scaleFactor - factor) } ?: MEDIUM
        }
    }
}

/**
 * CompositionLocal für den aktuellen Text-Skalierungsfaktor,
 * damit auch individuelle Layout-Höhen / Paddings darauf reagieren können.
 */
val LocalTextScale = compositionLocalOf { 1.0f }

private fun TextStyle.scale(factor: Float): TextStyle {
    return this.copy(
        fontSize = (this.fontSize.value * factor).sp,
        lineHeight = if (this.lineHeight != TextUnit.Unspecified) {
            (this.lineHeight.value * factor).sp
        } else {
            TextUnit.Unspecified
        }
    )
}

/**
 * Erzeugt eine voll skalierte Material3 Typography basierend auf dem gewählten Skalierungsfaktor.
 */
fun getScaledTypography(scaleFactor: Float = 1.0f): Typography {
    val base = Typography(
        displayLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            lineHeight = 40.sp,
            letterSpacing = (-0.5).sp
        ),
        displayMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.SemiBold,
            fontSize = 28.sp,
            lineHeight = 34.sp
        ),
        titleLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            lineHeight = 26.sp,
            letterSpacing = 0.sp
        ),
        titleMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            letterSpacing = 0.15.sp
        ),
        titleSmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            lineHeight = 22.sp,
            letterSpacing = 0.25.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.2.sp
        ),
        bodySmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 11.sp,
            lineHeight = 15.sp,
            letterSpacing = 0.3.sp
        ),
        labelLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.SemiBold,
            fontSize = 13.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.1.sp
        ),
        labelMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            lineHeight = 15.sp,
            letterSpacing = 0.2.sp
        ),
        labelSmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            lineHeight = 13.sp,
            letterSpacing = 0.3.sp
        )
    )

    if (scaleFactor == 1.0f) return base

    return Typography(
        displayLarge = base.displayLarge.scale(scaleFactor),
        displayMedium = base.displayMedium.scale(scaleFactor),
        titleLarge = base.titleLarge.scale(scaleFactor),
        titleMedium = base.titleMedium.scale(scaleFactor),
        titleSmall = base.titleSmall.scale(scaleFactor),
        bodyLarge = base.bodyLarge.scale(scaleFactor),
        bodyMedium = base.bodyMedium.scale(scaleFactor),
        bodySmall = base.bodySmall.scale(scaleFactor),
        labelLarge = base.labelLarge.scale(scaleFactor),
        labelMedium = base.labelMedium.scale(scaleFactor),
        labelSmall = base.labelSmall.scale(scaleFactor)
    )
}

val AppTypography = getScaledTypography(1.0f)
