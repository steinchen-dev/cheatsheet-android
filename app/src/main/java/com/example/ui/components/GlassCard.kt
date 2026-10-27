package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ui.theme.LocalGlassColors

/**
 * Universelle Glassmorphism-Karte im Squircle-Design.
 *
 * Kombiniert:
 * - Halbtransparente "Frosted Glass"-Oberfläche
 * - 1.dp Lichtkanten-Border mit linearem Alpha-Gradienten (Simulation von Top-Left Lichtfall)
 * - 100 % performant auf allen Android-Versionen (kein RenderEffect-Crash oder Framedrop unter Android < 12)
 * - Barrierefreier Touch-Target & Ripple-Effekt
 */
@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(24.dp),
    backgroundColor: Color = LocalGlassColors.current.cardBackground,
    borderTopLeftColor: Color = LocalGlassColors.current.cardBorderTopLeft,
    borderBottomRightColor: Color = LocalGlassColors.current.cardBorderBottomRight,
    borderWidth: Dp = 1.dp,
    elevation: Dp = 0.dp,
    testTag: String = "glass_card",
    onClick: (() -> Unit)? = null,
    content: @Composable BoxScope.() -> Unit
) {
    val borderBrush = remember(borderTopLeftColor, borderBottomRightColor) {
        Brush.linearGradient(
            colors = listOf(
                borderTopLeftColor,
                borderTopLeftColor.copy(alpha = (borderTopLeftColor.alpha * 0.7f)),
                borderBottomRightColor
            )
        )
    }

    val shadowModifier = if (elevation > 0.dp) {
        Modifier.shadow(elevation = elevation, shape = shape, clip = false)
    } else {
        Modifier
    }

    val clickableModifier = if (onClick != null) {
        Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = ripple(color = borderTopLeftColor),
            role = Role.Button,
            onClick = onClick
        )
    } else {
        Modifier
    }

    Box(
        modifier = modifier
            .testTag(testTag)
            .then(shadowModifier)
            .clip(shape)
            .background(backgroundColor)
            .border(
                width = borderWidth,
                brush = borderBrush,
                shape = shape
            )
            .then(clickableModifier)
    ) {
        content()
    }
}
