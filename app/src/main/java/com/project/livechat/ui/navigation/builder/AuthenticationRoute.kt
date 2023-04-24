package com.project.livechat.ui.navigation.builder

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.project.livechat.ui.navigation.Routes
import com.project.livechat.ui.screens.AuthenticationScreen
import com.project.livechat.ui.utils.exitTransition
import com.project.livechat.ui.utils.popEnterTransition

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.authenticationRoute(
    navHostController: NavHostController,
    onBackPressedDispatcher: OnBackPressedDispatcher
) {
    composable(
        route = Routes.HomeRoute.route,
        popEnterTransition = { popEnterTransition },
        exitTransition = { exitTransition },
    ) {
        AuthenticationScreen(navHostController = navHostController, backPressedDispatcher = onBackPressedDispatcher)
    }
}