package com.marioioannou.quitsmokingnow.navigation

import androidx.compose.material.Colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Timer
import androidx.compose.ui.graphics.Color
import com.marioioannou.quitsmokingnow.ui.theme.GreenPrimary

val bottomNavItems = listOf(
    BottomNavItem(
        route = "home",
        selectedIcon = Icons.Filled.Home,
        selectedIconColor = GreenPrimary,
        unSelectedIcon = Icons.Filled.Home,
        unSelectedIconColor = Color.White,
        hasResults = false
    ),
    BottomNavItem(
        route = "result",
        selectedIcon = Icons.Filled.Receipt,
        selectedIconColor = GreenPrimary,
        unSelectedIcon = Icons.Filled.Receipt,
        unSelectedIconColor = Color.White,
        hasResults = false
    ),
    BottomNavItem(
        route = "clock",
        selectedIcon = Icons.Filled.Timer,
        selectedIconColor = GreenPrimary,
        unSelectedIcon = Icons.Filled.Timer,
        unSelectedIconColor = Color.White,
        hasResults = false
    ),
    BottomNavItem(
        route = "calculator",
        selectedIcon = Icons.Filled.Calculate,
        selectedIconColor = GreenPrimary,
        unSelectedIcon = Icons.Filled.Calculate,
        unSelectedIconColor = Color.White,
        hasResults = false
    )
)