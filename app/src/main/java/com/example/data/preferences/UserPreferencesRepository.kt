package com.example.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "cheatsheet_settings")

data class UserPreferences(
    val isDarkTheme: Boolean = true,
    val accentColorHex: Long = 0xFF84B0AE,
    val textScaleFactor: Float = 1.0f,
    val favoriteItemIds: Set<String> = emptySet()
)

class UserPreferencesRepository(private val context: Context) {

    private object PreferencesKeys {
        val IS_DARK_THEME = booleanPreferencesKey("is_dark_theme")
        val ACCENT_COLOR_HEX = longPreferencesKey("accent_color_hex")
        val TEXT_SCALE_FACTOR = floatPreferencesKey("text_scale_factor")
        val FAVORITE_ITEM_IDS = stringSetPreferencesKey("favorite_item_ids")
    }

    val userPreferencesFlow: Flow<UserPreferences> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val isDarkTheme = preferences[PreferencesKeys.IS_DARK_THEME] ?: true
            val accentColorHex = preferences[PreferencesKeys.ACCENT_COLOR_HEX] ?: 0xFF84B0AE
            val textScaleFactor = preferences[PreferencesKeys.TEXT_SCALE_FACTOR] ?: 1.0f
            val favoriteItemIds = preferences[PreferencesKeys.FAVORITE_ITEM_IDS] ?: emptySet()

            UserPreferences(
                isDarkTheme = isDarkTheme,
                accentColorHex = accentColorHex,
                textScaleFactor = textScaleFactor,
                favoriteItemIds = favoriteItemIds
            )
        }

    suspend fun setDarkTheme(isDark: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.IS_DARK_THEME] = isDark
        }
    }

    suspend fun setAccentColor(colorHex: Long) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.ACCENT_COLOR_HEX] = colorHex
        }
    }

    suspend fun setTextScaleFactor(factor: Float) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.TEXT_SCALE_FACTOR] = factor
        }
    }

    suspend fun toggleFavorite(itemId: String) {
        context.dataStore.edit { preferences ->
            val current = preferences[PreferencesKeys.FAVORITE_ITEM_IDS] ?: emptySet()
            preferences[PreferencesKeys.FAVORITE_ITEM_IDS] = if (current.contains(itemId)) {
                current - itemId
            } else {
                current + itemId
            }
        }
    }
}
