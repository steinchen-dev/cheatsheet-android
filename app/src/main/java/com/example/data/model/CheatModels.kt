package com.example.data.model

/**
 * Repräsentiert einen einzelnen Eintrag (z. B. Shortcut, CLI-Befehl oder Konfigurationszeile).
 */
data class CheatItem(
    val id: String,
    val title: String,
    val commandOrShortcut: String,
    val description: String,
    val isMonospace: Boolean = true,
    val tags: List<String> = emptyList()
)

/**
 * Eine logische Gruppierung von Cheat-Items innerhalb eines CheatSheets (z. B. "Grundlegende Befehle", "Shortcuts").
 */
data class CheatSection(
    val id: String,
    val title: String,
    val items: List<CheatItem>
)

/**
 * Hauptgruppen für die logische Strukturierung.
 */
enum class CategoryGroup(val label: String) {
    OFFICE_OS("Office & OS"),
    LINUX_DESKTOP("Linux & Desktop"),
    DEV_TOOLS("Dev & Tools"),
    DEVOPS_SYS("DevOps & Server"),
    KNOWLEDGE_TOOLS("Wissen & Tools")
}

/**
 * Icon-Typen für pixelgenaue Vektor-Darstellung im Kachel-Grid.
 */
enum class CategoryIconType {
    WINDOWS,
    EXCEL,
    WORD,
    POWERPOINT,
    GITHUB,
    LINUX,
    ARCH,
    FEDORA,
    MINT,
    HYPRLAND,
    KDE_PLASMA,
    BROWSER,
    PYTHON,
    HTML,
    CSS,
    JAVA,
    BASH,
    NETWORK_SSH,
    DOCKER,
    TLDR,
    TOOLS
}

/**
 * Eine vollständige CheatSheet-Kachel für das 3-Spalten-Grid.
 */
data class CheatCategory(
    val id: String,
    val title: String,
    val subtitle: String,
    val group: CategoryGroup,
    val iconType: CategoryIconType,
    val sections: List<CheatSection>
)
