package com.example.ui.theme

import androidx.compose.ui.graphics.Color

// ==========================================
// CheatSheet Exakte Farbpalette (Sturm/Meer)
// ==========================================

// Deep Midnight Blue (Dark Background)
val MidnightDarkBackground = Color(0xFF09151E)

// Dark Petrol (Dark Surface / Drawer / Cards)
val DarkPetrolSurface = Color(0xFF0B2B36)

// Muted Slate Teal (Secondary / Card Borders / Icons)
val MutedSlateTeal = Color(0xFF527276)

// Soft Seafoam Cyan (Primary Accent / Active Toggles / Highlights)
val SoftSeafoamCyan = Color(0xFF84B0AE)

// Light Ice Gray (Light Mode Background / Primary Text im Dark Mode)
val LightIceGray = Color(0xFFCFD5D7)

// ==========================================
// Zusätzliche Light-Mode & Hilfsfarben
// ==========================================
val LightBackground = Color(0xFFECEFF1)
val LightSurface = Color(0xFFF7F9FA)
val DarkTextPrimary = Color(0xFF0B1922)
val DarkTextSecondary = Color(0xFF455A64)

// ==========================================
// Akzentfarben-Palette für den Settings-Picker
// ==========================================
val AccentSeafoamCyan = SoftSeafoamCyan     // #84B0AE (Standard)
val AccentTealGlow   = Color(0xFF4DB6AC)     // Helles Türkis
val AccentSkyBlue    = Color(0xFF64B5F6)     // Himmelblau
val AccentMintGreen  = Color(0xFF81C784)     // Minzgrün
val AccentAmberWarm  = Color(0xFFFFB74D)     // Warmes Bernstein
val AccentCoralRose  = Color(0xFFE57373)     // Korallenrosa

val AvailableAccentColors = listOf(
    AccentSeafoamCyan,
    AccentTealGlow,
    AccentSkyBlue,
    AccentMintGreen,
    AccentAmberWarm,
    AccentCoralRose
)
