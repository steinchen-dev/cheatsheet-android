package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.CategoryGroup
import com.example.data.model.CheatCategory
import com.example.data.model.CheatItem
import com.example.data.preferences.UserPreferences
import com.example.data.preferences.UserPreferencesRepository
import com.example.data.repository.CheatDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class SearchMatch(
    val category: CheatCategory,
    val item: CheatItem
)

data class MainUiState(
    val categories: List<CheatCategory> = emptyList(),
    val filteredCategories: List<CheatCategory> = emptyList(),
    val itemMatches: List<SearchMatch> = emptyList(),
    val selectedCategory: CheatCategory? = null,
    val selectedGroup: CategoryGroup? = null,
    val searchQuery: String = "",
    val preferences: UserPreferences = UserPreferences()
)

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val preferencesRepository = UserPreferencesRepository(application.applicationContext)

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow<CheatCategory?>(null)
    val selectedCategory = _selectedCategory.asStateFlow()

    private val _selectedGroup = MutableStateFlow<CategoryGroup?>(null)
    val selectedGroup = _selectedGroup.asStateFlow()

    private val allCategories = CheatDataProvider.allCategories

    val preferences: StateFlow<UserPreferences> = preferencesRepository.userPreferencesFlow
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UserPreferences()
        )

    val uiState: StateFlow<MainUiState> = combine(
        _searchQuery,
        _selectedCategory,
        _selectedGroup,
        preferences
    ) { query, selectedCat, group, prefs ->
        val trimmed = query.trim().lowercase()

        val filteredCats = allCategories.filter { cat ->
            val matchesGroup = group == null || cat.group == group
            if (!matchesGroup) return@filter false

            if (trimmed.isEmpty()) return@filter true

            val matchesTitle = cat.title.lowercase().contains(trimmed)
            val matchesSub = cat.subtitle.lowercase().contains(trimmed)
            val matchesAnyItem = cat.sections.any { sec ->
                sec.items.any { item ->
                    item.title.lowercase().contains(trimmed) ||
                    item.commandOrShortcut.lowercase().contains(trimmed) ||
                    item.description.lowercase().contains(trimmed) ||
                    item.tags.any { it.lowercase().contains(trimmed) }
                }
            }

            matchesTitle || matchesSub || matchesAnyItem
        }

        val matches = if (trimmed.isNotEmpty()) {
            allCategories.flatMap { cat ->
                cat.sections.flatMap { sec ->
                    sec.items.filter { item ->
                        item.title.lowercase().contains(trimmed) ||
                        item.commandOrShortcut.lowercase().contains(trimmed) ||
                        item.description.lowercase().contains(trimmed) ||
                        item.tags.any { it.lowercase().contains(trimmed) }
                    }.map { SearchMatch(cat, it) }
                }
            }
        } else {
            emptyList()
        }

        MainUiState(
            categories = allCategories,
            filteredCategories = filteredCats,
            itemMatches = matches,
            selectedCategory = selectedCat,
            selectedGroup = group,
            searchQuery = query,
            preferences = prefs
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = MainUiState(
            categories = allCategories,
            filteredCategories = allCategories
        )
    )

    fun onSearchQueryChanged(newQuery: String) {
        _searchQuery.value = newQuery
    }

    fun onCategorySelected(category: CheatCategory?) {
        _selectedCategory.value = category
    }

    fun onGroupSelected(group: CategoryGroup?) {
        _selectedGroup.value = if (_selectedGroup.value == group) null else group
    }

    fun toggleFavorite(itemId: String) {
        viewModelScope.launch {
            preferencesRepository.toggleFavorite(itemId)
        }
    }

    fun setDarkTheme(isDark: Boolean) {
        viewModelScope.launch {
            preferencesRepository.setDarkTheme(isDark)
        }
    }

    fun setAccentColor(colorHex: Long) {
        viewModelScope.launch {
            preferencesRepository.setAccentColor(colorHex)
        }
    }

    fun setTextScaleFactor(factor: Float) {
        viewModelScope.launch {
            preferencesRepository.setTextScaleFactor(factor)
        }
    }
}
