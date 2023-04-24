package com.project.livechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.project.livechat.ui.navigation.Screens
import com.project.livechat.ui.navigation.builder.homeScreen
import com.project.livechat.ui.theme.LiveChatTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LiveChatTheme {
                val navController = rememberAnimatedNavController()
                AnimatedNavHost(
                    navController = navController,
                    startDestination = Screens.HomeScreen.route,
                    builder = {
                        homeScreen(
                            navHostController = navController,
                            onBackPressedDispatcher = onBackPressedDispatcher
                        )
                    }
                )
            }
        }
    }
}