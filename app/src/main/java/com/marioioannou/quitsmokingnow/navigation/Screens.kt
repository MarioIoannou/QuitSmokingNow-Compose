package com.marioioannou.quitsmokingnow.navigation

sealed class Screens(val screen: String) {
    data object Home: Screens("home")
    data object Result: Screens("result")
    data object Clock: Screens("clock")
    data object Calculator: Screens("calculator")
}