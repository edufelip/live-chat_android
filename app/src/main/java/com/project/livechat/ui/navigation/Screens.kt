package com.project.livechat.ui.navigation

import androidx.navigation.NavHostController

sealed class Screens(val route: String, val argumentKey: String) {
    fun navigate(navHostController: NavHostController) {
        navHostController.navigate(route)
    }

    fun <T> navigateWithArgument(
        navHostController: NavHostController,
        argumentValue: T?
    ) {
        navHostController.currentBackStackEntry?.savedStateHandle?.set(
            key = argumentKey,
            value = argumentValue
        )
        navigate(navHostController)
    }

    fun <T> navigateWithArgumentList(
        navHostController: NavHostController,
        argumentValue: List<T>?
    ) {
        navHostController.currentBackStackEntry?.savedStateHandle?.set(
            key = argumentKey,
            value = argumentValue
        )
        navigate(navHostController)
    }

    object HomeScreen : Screens(
        route = "home_screen",
        argumentKey = "ARGS-HOME-SCREEN"
    )

    object NewChatScreen : Screens(
        route = "new_chat_screen",
        argumentKey = "ARGS-NEW-CHAT-SCREEN"
    )

    object ChatScreen : Screens(
        route = "chat_screen",
        argumentKey = "ARGS-CHAT-SCREEN"
    )
}