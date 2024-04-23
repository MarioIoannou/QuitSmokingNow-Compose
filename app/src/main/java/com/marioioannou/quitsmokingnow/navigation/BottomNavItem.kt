package com.marioioannou.quitsmokingnow.navigation

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val route: String,
    val selectedIcon: ImageVector,
    val selectedIconColor: Color,
    val unSelectedIcon: ImageVector,
    val unSelectedIconColor: Color,
    val hasResults: Boolean
) {
}