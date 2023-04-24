package com.project.livechat.ui.screens

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.project.livechat.ui.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navHostController: NavHostController,
    backPressedDispatcher: OnBackPressedDispatcher
) {
    LaunchedEffect(key1 = Unit) {
//        val mAuth = FirebaseAuth.getInstance()
//        val currentUser = mAuth.currentUser
//        if (currentUser != null) Routes.AuthenticationRoute.navigate(navHostController)
    }
    Scaffold(
        topBar = {},
        floatingActionButton = {}
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {

        }
    }
}