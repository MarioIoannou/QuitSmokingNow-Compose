package com.marioioannou.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marioioannou.quitsmokingnow.navigation.Screens
import com.marioioannou.quitsmokingnow.navigation.bottomNavItems
import com.marioioannou.quitsmokingnow.presentation.cigarette_counter.CigaretteCounterScreen
import com.marioioannou.quitsmokingnow.presentation.cigarette_craving.CigaretteCravingScreen
import com.marioioannou.quitsmokingnow.ui.theme.CyanSecondary
import com.marioioannou.quitsmokingnow.ui.theme.GreenPrimary
import com.marioioannou.quitsmokingnow.ui.theme.QuitSmokingNowTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            QuitSmokingNowTheme {

                val selectedItem = remember { mutableIntStateOf(0) }
                val navController = rememberNavController()

                Scaffold(
                    topBar = {

                    },
                    bottomBar = {
                        NavigationBar(
                            // Make bottomNavBar floating
                            modifier = Modifier
                                .padding(12.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            containerColor = CyanSecondary
                        ){

                            bottomNavItems.forEachIndexed { index, bottomNavItem ->

                                BottomNavigationItem(
                                    modifier = Modifier.align(alignment = Alignment.CenterVertically),
                                    selected = selectedItem.intValue == index,
                                    onClick = {
                                              selectedItem.intValue = index
                                              navController.navigate(bottomNavItem.route)
                                              },
                                    icon = {
                                            // Show red dot on top right
                                           BadgedBox(
                                               badge = {
                                               if (bottomNavItem.hasResults){
                                                   Badge()
                                               }
                                           }) {
                                               Icon(
                                                   modifier = Modifier.size(size = 28.dp),
                                                   imageVector =
                                                        if(selectedItem.intValue == index){
                                                            bottomNavItem.selectedIcon
                                                        }else {
                                                            bottomNavItem.unSelectedIcon
                                                        },
                                                   contentDescription = null
                                               )
                                           }
                                    },
                                    selectedContentColor = GreenPrimary,
                                    unselectedContentColor = Color.White,
                                    // Disable Titles
                                    alwaysShowLabel = false
                                )
                            }
                        }
                    }
                ) {
                    val padding = it
                    NavHost(
                        navController = navController,
                        startDestination = Screens.Home.screen,
                        modifier = Modifier.padding(padding)
                    ) {
                        composable(Screens.Home.screen){ CigaretteCounterScreen()}
                        composable(Screens.Result.screen){ }
                        composable(Screens.Clock.screen){ CigaretteCravingScreen() }
                        composable(Screens.Calculator.screen){}
                    }
                }
            }
        }
    }
}