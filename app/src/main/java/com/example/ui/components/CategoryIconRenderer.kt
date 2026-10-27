package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.CategoryIconType

/**
 * Zeichnet pixelgenaue, hardware-beschleunigte Vektor-Icons für jede Kategorie,
 * inklusive der neuen IT-Lexikon & Power-Tools Kacheln.
 */
@Composable
fun CategoryIcon(
    iconType: CategoryIconType,
    modifier: Modifier = Modifier,
    size: Dp = 40.dp
) {
    Box(
        modifier = modifier.size(size),
        contentAlignment = Alignment.Center
    ) {
        when (iconType) {
            CategoryIconType.WINDOWS -> WindowsIcon(size)
            CategoryIconType.EXCEL -> OfficeAppBadge(size, "X", Color(0xFF107C41))
            CategoryIconType.WORD -> OfficeAppBadge(size, "W", Color(0xFF185ABD))
            CategoryIconType.POWERPOINT -> OfficeAppBadge(size, "P", Color(0xFFC43E1C))
            CategoryIconType.GITHUB -> GitHubIcon(size)
            CategoryIconType.LINUX -> LinuxTuxIcon(size)
            CategoryIconType.ARCH -> ArchLinuxIcon(size)
            CategoryIconType.FEDORA -> FedoraIcon(size)
            CategoryIconType.MINT -> LinuxMintIcon(size)
            CategoryIconType.HYPRLAND -> HyprlandIcon(size)
            CategoryIconType.KDE_PLASMA -> KdePlasmaIcon(size)
            CategoryIconType.BROWSER -> BrowserGlobeIcon(size)
            CategoryIconType.PYTHON -> PythonDualIcon(size)
            CategoryIconType.HTML -> WebTechBadge(size, "HTML", "5", Color(0xFFE44D26))
            CategoryIconType.CSS -> WebTechBadge(size, "CSS", "3", Color(0xFF264DE4))
            CategoryIconType.JAVA -> JavaCoffeeIcon(size)
            CategoryIconType.BASH -> BashTerminalIcon(size)
            CategoryIconType.NETWORK_SSH -> NetworkSshIcon(size)
            CategoryIconType.DOCKER -> DockerWhaleIcon(size)
            CategoryIconType.TLDR -> TldrBookIcon(size)
            CategoryIconType.TOOLS -> ToolsWrenchIcon(size)
        }
    }
}

@Composable
private fun OfficeAppBadge(size: Dp, letter: String, brandColor: Color) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        drawRoundRect(
            color = brandColor,
            size = Size(w, h),
            cornerRadius = CornerRadius(w * 0.22f, h * 0.22f)
        )
    }
    Text(
        text = letter,
        color = Color.White,
        fontSize = (size.value * 0.55f).sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
private fun WebTechBadge(size: Dp, sub: String, number: String, brandColor: Color) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val path = Path().apply {
            moveTo(w * 0.15f, h * 0.12f)
            lineTo(w * 0.85f, h * 0.12f)
            lineTo(w * 0.78f, h * 0.78f)
            lineTo(w * 0.50f, h * 0.92f)
            lineTo(w * 0.22f, h * 0.78f)
            close()
        }
        drawPath(path, color = brandColor)
    }
    Text(
        text = number,
        color = Color.White,
        fontSize = (size.value * 0.48f).sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
private fun WindowsIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val gap = w * 0.08f
        val halfW = (w - gap) / 2f
        val halfH = (h - gap) / 2f
        val blue = Color(0xFF0078D4)

        drawRect(color = blue, topLeft = Offset(0f, 0f), size = Size(halfW, halfH))
        drawRect(color = blue, topLeft = Offset(halfW + gap, 0f), size = Size(halfW, halfH))
        drawRect(color = blue, topLeft = Offset(0f, halfH + gap), size = Size(halfW, halfH))
        drawRect(color = blue, topLeft = Offset(halfW + gap, halfH + gap), size = Size(halfW, halfH))
    }
}

@Composable
private fun GitHubIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val dark = Color(0xFF24292E)
        drawCircle(color = dark, radius = w * 0.46f, center = Offset(w / 2f, h / 2f))
        val path = Path().apply {
            moveTo(w * 0.35f, h * 0.38f)
            lineTo(w * 0.30f, h * 0.25f)
            lineTo(w * 0.42f, h * 0.32f)
            lineTo(w * 0.58f, h * 0.32f)
            lineTo(w * 0.70f, h * 0.25f)
            lineTo(w * 0.65f, h * 0.38f)
            close()
        }
        drawPath(path, color = Color.White)
        drawCircle(color = Color.White, radius = w * 0.24f, center = Offset(w / 2f, h * 0.54f))
    }
}

@Composable
private fun LinuxTuxIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        drawOval(
            color = Color(0xFF212121),
            topLeft = Offset(w * 0.22f, h * 0.20f),
            size = Size(w * 0.56f, h * 0.72f)
        )
        drawOval(
            color = Color.White,
            topLeft = Offset(w * 0.32f, h * 0.40f),
            size = Size(w * 0.36f, h * 0.48f)
        )
        drawOval(
            color = Color(0xFFFFB300),
            topLeft = Offset(w * 0.40f, h * 0.32f),
            size = Size(w * 0.20f, h * 0.14f)
        )
    }
}

@Composable
private fun ArchLinuxIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val archCyan = Color(0xFF1793D1)
        val path = Path().apply {
            moveTo(w * 0.50f, h * 0.12f)
            lineTo(w * 0.18f, h * 0.88f)
            lineTo(w * 0.38f, h * 0.88f)
            lineTo(w * 0.50f, h * 0.58f)
            lineTo(w * 0.62f, h * 0.88f)
            lineTo(w * 0.82f, h * 0.88f)
            close()
        }
        drawPath(path, color = archCyan)
    }
}

@Composable
private fun FedoraIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val fedoraBlue = Color(0xFF294172)
        val infinityCyan = Color(0xFF3C6EB4)
        drawCircle(color = fedoraBlue, radius = w * 0.46f, center = Offset(w / 2f, h / 2f))
        drawCircle(
            color = infinityCyan,
            radius = w * 0.20f,
            center = Offset(w * 0.45f, h * 0.50f),
            style = Stroke(width = w * 0.10f)
        )
    }
}

@Composable
private fun LinuxMintIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val mintGreen = Color(0xFF87CF3E)
        drawRoundRect(
            color = mintGreen,
            size = Size(w, h),
            cornerRadius = CornerRadius(w * 0.24f, h * 0.24f)
        )
        val path = Path().apply {
            moveTo(w * 0.30f, h * 0.70f)
            lineTo(w * 0.30f, h * 0.35f)
            lineTo(w * 0.50f, h * 0.35f)
            lineTo(w * 0.50f, h * 0.65f)
            lineTo(w * 0.70f, h * 0.35f)
            lineTo(w * 0.70f, h * 0.70f)
        }
        drawPath(
            path,
            color = Color.White,
            style = Stroke(width = w * 0.10f, cap = StrokeCap.Round, join = StrokeJoin.Round)
        )
    }
}

@Composable
private fun HyprlandIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val hyprCyan = Color(0xFF00F0FF)
        val path1 = Path().apply {
            moveTo(w * 0.50f, h * 0.15f)
            lineTo(w * 0.15f, h * 0.85f)
            lineTo(w * 0.85f, h * 0.85f)
            close()
        }
        drawPath(path1, color = hyprCyan, style = Stroke(width = w * 0.09f))
        drawCircle(color = hyprCyan, radius = w * 0.12f, center = Offset(w / 2f, h * 0.58f))
    }
}

@Composable
private fun KdePlasmaIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val kdeBlue = Color(0xFF1D99F3)
        drawCircle(
            color = kdeBlue,
            radius = w * 0.36f,
            center = Offset(w / 2f, h / 2f),
            style = Stroke(width = w * 0.10f)
        )
        drawLine(
            color = kdeBlue,
            start = Offset(w * 0.35f, h * 0.28f),
            end = Offset(w * 0.35f, h * 0.72f),
            strokeWidth = w * 0.10f,
            cap = StrokeCap.Round
        )
        drawLine(
            color = kdeBlue,
            start = Offset(w * 0.35f, h * 0.50f),
            end = Offset(w * 0.65f, h * 0.28f),
            strokeWidth = w * 0.10f,
            cap = StrokeCap.Round
        )
        drawLine(
            color = kdeBlue,
            start = Offset(w * 0.35f, h * 0.50f),
            end = Offset(w * 0.65f, h * 0.72f),
            strokeWidth = w * 0.10f,
            cap = StrokeCap.Round
        )
    }
}

@Composable
private fun BrowserGlobeIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val globeTeal = Color(0xFF00ACC1)
        drawCircle(
            color = globeTeal,
            radius = w * 0.42f,
            center = Offset(w / 2f, h / 2f),
            style = Stroke(width = w * 0.08f)
        )
        drawOval(
            color = globeTeal,
            topLeft = Offset(w * 0.26f, h * 0.08f),
            size = Size(w * 0.48f, h * 0.84f),
            style = Stroke(width = w * 0.06f)
        )
        drawLine(
            color = globeTeal,
            start = Offset(w * 0.08f, h / 2f),
            end = Offset(w * 0.92f, h / 2f),
            strokeWidth = w * 0.06f
        )
    }
}

@Composable
private fun PythonDualIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val pyBlue = Color(0xFF3776AB)
        val pyYellow = Color(0xFFFFD43B)

        drawRoundRect(
            color = pyBlue,
            topLeft = Offset(w * 0.15f, h * 0.15f),
            size = Size(w * 0.50f, h * 0.45f),
            cornerRadius = CornerRadius(w * 0.15f, h * 0.15f)
        )
        drawCircle(color = Color.White, radius = w * 0.05f, center = Offset(w * 0.32f, h * 0.28f))

        drawRoundRect(
            color = pyYellow,
            topLeft = Offset(w * 0.35f, h * 0.40f),
            size = Size(w * 0.50f, h * 0.45f),
            cornerRadius = CornerRadius(w * 0.15f, h * 0.15f)
        )
        drawCircle(color = Color.White, radius = w * 0.05f, center = Offset(w * 0.68f, h * 0.72f))
    }
}

@Composable
private fun JavaCoffeeIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val javaRed = Color(0xFFE76F00)
        val javaBlue = Color(0xFF5382A1)

        val steam = Path().apply {
            moveTo(w * 0.40f, h * 0.15f)
            cubicTo(w * 0.55f, h * 0.22f, w * 0.35f, h * 0.32f, w * 0.50f, h * 0.42f)
        }
        drawPath(steam, color = javaRed, style = Stroke(width = w * 0.07f, cap = StrokeCap.Round))

        val cup = Path().apply {
            moveTo(w * 0.25f, h * 0.50f)
            lineTo(w * 0.75f, h * 0.50f)
            cubicTo(w * 0.72f, h * 0.85f, w * 0.28f, h * 0.85f, w * 0.25f, h * 0.50f)
            close()
        }
        drawPath(cup, color = javaBlue)
    }
}

@Composable
private fun BashTerminalIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val dark = Color(0xFF1E293B)
        val green = Color(0xFF10B981)

        drawRoundRect(
            color = dark,
            size = Size(w, h),
            cornerRadius = CornerRadius(w * 0.20f, h * 0.20f)
        )
        val path = Path().apply {
            moveTo(w * 0.25f, h * 0.32f)
            lineTo(w * 0.45f, h * 0.48f)
            lineTo(w * 0.25f, h * 0.64f)
        }
        drawPath(path, color = green, style = Stroke(width = w * 0.08f, cap = StrokeCap.Round))
        drawLine(
            color = green,
            start = Offset(w * 0.52f, h * 0.64f),
            end = Offset(w * 0.75f, h * 0.64f),
            strokeWidth = w * 0.08f,
            cap = StrokeCap.Round
        )
    }
}

@Composable
private fun NetworkSshIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val purple = Color(0xFF8B5CF6)
        val nodeColor = Color(0xFFA78BFA)

        val c1 = Offset(w * 0.50f, h * 0.25f)
        val c2 = Offset(w * 0.25f, h * 0.75f)
        val c3 = Offset(w * 0.75f, h * 0.75f)

        drawLine(color = nodeColor, start = c1, end = c2, strokeWidth = w * 0.06f)
        drawLine(color = nodeColor, start = c1, end = c3, strokeWidth = w * 0.06f)
        drawLine(color = nodeColor, start = c2, end = c3, strokeWidth = w * 0.06f)

        drawCircle(color = purple, radius = w * 0.14f, center = c1)
        drawCircle(color = purple, radius = w * 0.14f, center = c2)
        drawCircle(color = purple, radius = w * 0.14f, center = c3)
    }
}

@Composable
private fun DockerWhaleIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val dockerBlue = Color(0xFF0DB7ED)

        val whale = Path().apply {
            moveTo(w * 0.15f, h * 0.55f)
            cubicTo(w * 0.20f, h * 0.78f, w * 0.70f, h * 0.82f, w * 0.85f, h * 0.55f)
            lineTo(w * 0.90f, h * 0.45f)
            lineTo(w * 0.80f, h * 0.50f)
            close()
        }
        drawPath(whale, color = dockerBlue)

        val cW = w * 0.10f
        val cH = h * 0.09f
        drawRect(color = dockerBlue, topLeft = Offset(w * 0.35f, h * 0.42f), size = Size(cW, cH))
        drawRect(color = dockerBlue, topLeft = Offset(w * 0.48f, h * 0.42f), size = Size(cW, cH))
        drawRect(color = dockerBlue, topLeft = Offset(w * 0.61f, h * 0.42f), size = Size(cW, cH))
        drawRect(color = dockerBlue, topLeft = Offset(w * 0.48f, h * 0.30f), size = Size(cW, cH))
    }
}

@Composable
private fun TldrBookIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val cyan = Color(0xFF84B0AE)
        val amber = Color(0xFFFFB74D)

        // Aufgeschlagenes Buch
        val leftPage = Path().apply {
            moveTo(w * 0.48f, h * 0.28f)
            cubicTo(w * 0.35f, h * 0.24f, w * 0.20f, h * 0.26f, w * 0.15f, h * 0.28f)
            lineTo(w * 0.15f, h * 0.75f)
            cubicTo(w * 0.20f, h * 0.73f, w * 0.35f, h * 0.71f, w * 0.48f, h * 0.75f)
            close()
        }
        drawPath(leftPage, color = cyan)

        val rightPage = Path().apply {
            moveTo(w * 0.52f, h * 0.28f)
            cubicTo(w * 0.65f, h * 0.24f, w * 0.80f, h * 0.26f, w * 0.85f, h * 0.28f)
            lineTo(w * 0.85f, h * 0.75f)
            cubicTo(w * 0.80f, h * 0.73f, w * 0.65f, h * 0.71f, w * 0.52f, h * 0.75f)
            close()
        }
        drawPath(rightPage, color = cyan.copy(alpha = 0.85f))

        // Glühbirnen-Symbol über dem Buch
        drawCircle(color = amber, radius = w * 0.10f, center = Offset(w / 2f, h * 0.18f))
    }
}

@Composable
private fun ToolsWrenchIcon(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val teal = Color(0xFF527276)
        val cyan = Color(0xFF84B0AE)

        // Gekreuzter Schraubenschlüssel
        drawLine(
            color = cyan,
            start = Offset(w * 0.22f, h * 0.78f),
            end = Offset(w * 0.78f, h * 0.22f),
            strokeWidth = w * 0.12f,
            cap = StrokeCap.Round
        )
        // Maulschlüssel-Kopf
        drawCircle(
            color = cyan,
            radius = w * 0.16f,
            center = Offset(w * 0.78f, h * 0.22f),
            style = Stroke(width = w * 0.08f)
        )

        // Gekreuzter Schraubendreher
        drawLine(
            color = teal,
            start = Offset(w * 0.78f, h * 0.78f),
            end = Offset(w * 0.22f, h * 0.22f),
            strokeWidth = w * 0.08f,
            cap = StrokeCap.Round
        )
        // Griff
        drawLine(
            color = Color.White,
            start = Offset(w * 0.68f, h * 0.68f),
            end = Offset(w * 0.78f, h * 0.78f),
            strokeWidth = w * 0.14f,
            cap = StrokeCap.Round
        )
    }
}
