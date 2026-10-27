package com.example.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.CategoryGroup
import com.example.data.model.CheatCategory
import com.example.data.model.CheatItem
import com.example.ui.components.CategoryIcon
import com.example.ui.components.GlassCard
import com.example.ui.theme.LocalGlassColors
import com.example.ui.theme.LocalTextScale
import com.example.ui.viewmodel.MainUiState

/**
 * Hauptbildschirm der CheatSheet App:
 * - Top-Bar mit Hamburger-Menü (☰) und zentriertem Titel
 * - Pill-Suchleiste mit Echtzeit-Filterung
 * - Filter-Chips für Hauptkategorien
 * - 3-Spalten Squircle-Grid (mit responsiver Skalierung)
 * - Direkte Item-Trefferliste bei spezifischer Suche
 * - Schwebendes "✓ Offline & Nativ" Pill-Badge
 */
@Composable
fun MainHomeScreen(
    uiState: MainUiState,
    onOpenDrawer: () -> Unit,
    onSearchChanged: (String) -> Unit,
    onCategoryClick: (CheatCategory) -> Unit,
    onGroupSelected: (CategoryGroup?) -> Unit,
    onToggleFavorite: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val textScale = LocalTextScale.current
    val glassColors = LocalGlassColors.current

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // 1. Top-Bar: Hamburger (links) & zentrierter App-Titel
            CheatSheetTopBar(
                onOpenDrawer = onOpenDrawer,
                title = "CheatSheet"
            )

            Spacer(modifier = Modifier.height(12.dp))

            // 2. Pill-Suchleiste
            PillSearchBar(
                query = uiState.searchQuery,
                onQueryChange = onSearchChanged
            )

            Spacer(modifier = Modifier.height(10.dp))

            // 3. Horizontale Kategorie-Filter-Chips
            CategoryFilterBar(
                selectedGroup = uiState.selectedGroup,
                onGroupSelected = onGroupSelected
            )

            Spacer(modifier = Modifier.height(10.dp))

            // 4. Content-Bereich: Entweder 3-Spalten-Kachel-Grid oder direkte Suchtreffer
            if (uiState.searchQuery.isNotBlank() && uiState.itemMatches.isNotEmpty()) {
                // Direkte Befehls-Trefferliste bei spezifischer Suche
                SearchMatchesList(
                    matches = uiState.itemMatches,
                    favoriteIds = uiState.preferences.favoriteItemIds,
                    onToggleFavorite = onToggleFavorite,
                    modifier = Modifier.weight(1f)
                )
            } else {
                // 3-Spalten-Grid der Kategorien
                CategoryGrid(
                    categories = uiState.filteredCategories,
                    onCategoryClick = onCategoryClick,
                    textScale = textScale,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 5. Schwebendes Offline-Badge
            OfflineBadge(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 12.dp)
            )
        }
    }
}

@Composable
private fun CheatSheetTopBar(
    onOpenDrawer: () -> Unit,
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onOpenDrawer,
            modifier = Modifier
                .size(44.dp)
                .testTag("menu_button")
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Einstellungen öffnen",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )

        // Platzhalter für symmetrische Ausrichtung
        Spacer(modifier = Modifier.size(44.dp))
    }
}

@Composable
private fun PillSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val glassColors = LocalGlassColors.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(50))
            .background(glassColors.searchBarBackground)
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(
                    listOf(
                        glassColors.cardBorderTopLeft,
                        glassColors.searchBarBorder
                    )
                ),
                shape = RoundedCornerShape(50)
            )
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            BasicTextField(
                value = query,
                onValueChange = onQueryChange,
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground
                ),
                cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .weight(1f)
                    .testTag("search_input"),
                decorationBox = { innerTextField ->
                    if (query.isEmpty()) {
                        Text(
                            text = "Suche nach Shortcuts, Befehlen...",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.65f),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    innerTextField()
                }
            )

            if (query.isNotEmpty()) {
                IconButton(
                    onClick = { onQueryChange("") },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Suche leeren",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}

@Composable
private fun CategoryFilterBar(
    selectedGroup: CategoryGroup?,
    onGroupSelected: (CategoryGroup?) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterChip(
            selected = selectedGroup == null,
            onClick = { onGroupSelected(null) },
            label = { Text("Alle") },
            shape = RoundedCornerShape(50),
            colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.25f),
                selectedLabelColor = MaterialTheme.colorScheme.primary
            )
        )
        CategoryGroup.entries.forEach { group ->
            FilterChip(
                selected = selectedGroup == group,
                onClick = { onGroupSelected(group) },
                label = { Text(group.label) },
                shape = RoundedCornerShape(50),
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.25f),
                    selectedLabelColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}

@Composable
private fun CategoryGrid(
    categories: List<CheatCategory>,
    onCategoryClick: (CheatCategory) -> Unit,
    textScale: Float,
    modifier: Modifier = Modifier
) {
    if (categories.isEmpty()) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Keine passenden Kategorien gefunden",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        return
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(top = 4.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(categories, key = { it.id }) { category ->
            CategoryTile(
                category = category,
                textScale = textScale,
                onClick = { onCategoryClick(category) }
            )
        }
    }
}

@Composable
private fun CategoryTile(
    category: CheatCategory,
    textScale: Float,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val minTileHeight = if (textScale > 1.1f) 140.dp else 126.dp

    GlassCard(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = minTileHeight),
        shape = RoundedCornerShape(24.dp),
        testTag = "category_tile_${category.id}",
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CategoryIcon(
                iconType = category.iconType,
                size = 38.dp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = category.title,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = category.subtitle,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.85f),
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 12.sp
            )
        }
    }
}

@Composable
private fun SearchMatchesList(
    matches: List<com.example.ui.viewmodel.SearchMatch>,
    favoriteIds: Set<String>,
    onToggleFavorite: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val clipboard = LocalClipboardManager.current

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(top = 4.dp, bottom = 12.dp)
    ) {
        items(matches, key = { "${it.category.id}_${it.item.id}" }) { match ->
            val isFav = favoriteIds.contains(match.item.id)

            GlassCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                testTag = "search_match_${match.item.id}"
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CategoryIcon(iconType = match.category.iconType, size = 20.dp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = match.category.title,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(
                            onClick = { onToggleFavorite(match.item.id) },
                            modifier = Modifier.size(28.dp)
                        ) {
                            Icon(
                                imageVector = if (isFav) Icons.Default.Star else Icons.Outlined.StarBorder,
                                contentDescription = "Favorit umschalten",
                                tint = if (isFav) Color(0xFFFFC107) else MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = match.item.title,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    // Befehl mit Copy-Button
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                            .padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = match.item.commandOrShortcut,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontFamily = if (match.item.isMonospace) FontFamily.Monospace else FontFamily.Default,
                                fontWeight = FontWeight.SemiBold
                            ),
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.weight(1f)
                        )
                        IconButton(
                            onClick = {
                                clipboard.setText(AnnotatedString(match.item.commandOrShortcut))
                                Toast.makeText(context, "Kopiert!", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.size(28.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ContentCopy,
                                contentDescription = "Kopieren",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }

                    if (match.item.description.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = match.item.description,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun OfflineBadge(modifier: Modifier = Modifier) {
    val glassColors = LocalGlassColors.current

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(glassColors.badgeBackground)
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(
                    listOf(
                        glassColors.cardBorderTopLeft,
                        glassColors.cardBorderBottomRight
                    )
                ),
                shape = RoundedCornerShape(50)
            )
            .padding(horizontal = 18.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "✓ Offline & Nativ",
            style = MaterialTheme.typography.labelMedium,
            color = glassColors.badgeContent,
            fontWeight = FontWeight.SemiBold
        )
    }
}
