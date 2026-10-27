package com.example

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.SettingsDrawerContent
import com.example.ui.screens.CheatDetailScreen
import com.example.ui.screens.MainHomeScreen
import com.example.ui.theme.CheatSheetTheme
import com.example.ui.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 120Hz / High Refresh Rate Unlock:
        // Verhindert das automatische Herunterdrosseln auf 60Hz auf modernen Displays
        enableHighRefreshRate()

        setContent {
            val mainViewModel: MainViewModel = viewModel()
            val uiState by mainViewModel.uiState.collectAsStateWithLifecycle()

            val accentColor = Color(uiState.preferences.accentColorHex)
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val scope = rememberCoroutineScope()

            // 1. BackHandler für Drawer
            BackHandler(enabled = drawerState.isOpen) {
                scope.launch { drawerState.close() }
            }

            // 2. BackHandler für Detail-Ansicht (zurück zum Grid)
            BackHandler(enabled = uiState.selectedCategory != null && !drawerState.isOpen) {
                mainViewModel.onCategorySelected(null)
            }

            CheatSheetTheme(
                darkTheme = uiState.preferences.isDarkTheme,
                accentColor = accentColor,
                textScaleFactor = uiState.preferences.textScaleFactor
            ) {
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    scrimColor = Color.Black.copy(alpha = 0.55f),
                    drawerContent = {
                        SettingsDrawerContent(
                            preferences = uiState.preferences,
                            onDarkThemeToggle = mainViewModel::setDarkTheme,
                            onAccentColorSelect = mainViewModel::setAccentColor,
                            onTextScaleChange = mainViewModel::setTextScaleFactor
                        )
                    }
                ) {
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                    ) { innerPadding ->
                        AnimatedContent(
                            targetState = uiState.selectedCategory,
                            transitionSpec = { fadeIn() togetherWith fadeOut() },
                            label = "screen_transition"
                        ) { selectedCategory ->
                            if (selectedCategory != null) {
                                CheatDetailScreen(
                                    category = selectedCategory,
                                    favoriteItemIds = uiState.preferences.favoriteItemIds,
                                    onToggleFavorite = mainViewModel::toggleFavorite,
                                    onBack = { mainViewModel.onCategorySelected(null) },
                                    modifier = Modifier.padding(innerPadding)
                                )
                            } else {
                                MainHomeScreen(
                                    uiState = uiState,
                                    onOpenDrawer = {
                                        scope.launch { drawerState.open() }
                                    },
                                    onSearchChanged = mainViewModel::onSearchQueryChanged,
                                    onCategoryClick = { category ->
                                        mainViewModel.onCategorySelected(category)
                                    },
                                    onGroupSelected = mainViewModel::onGroupSelected,
                                    onToggleFavorite = mainViewModel::toggleFavorite,
                                    modifier = Modifier.padding(innerPadding)
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Ermittelt den höchsten verfügbaren Display-Modus (z. B. 90Hz, 120Hz oder 144Hz)
     * und weist den WindowManager an, diesen Modus dauerhaft aktiv zu halten.
     */
    private fun enableHighRefreshRate() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val currentDisplay = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    display
                } else {
                    @Suppress("DEPRECATION")
                    windowManager.defaultDisplay
                }

                val maxMode = currentDisplay?.supportedModes?.maxByOrNull { it.refreshRate }
                if (maxMode != null) {
                    val layoutParams = window.attributes
                    layoutParams.preferredDisplayModeId = maxMode.modeId
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        layoutParams.preferredRefreshRate = maxMode.refreshRate
                    }
                    window.attributes = layoutParams
                }
            }
        } catch (_: Exception) {
            // Graceful fallback
        }
    }
}
