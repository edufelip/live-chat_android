package com.project.livechat.ui.screens.contacts

import android.Manifest
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavHostController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ContactsScreen(
    navHostController: NavHostController,
    backPressedDispatcher: OnBackPressedDispatcher
) {
    val permissionState = rememberPermissionState(permission = Manifest.permission.READ_CONTACTS)
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifecycleOwner, effect = {
        val eventObserver = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    permissionState.launchPermissionRequest()
                }
                else -> Unit
            }
        }
        lifecycleOwner.lifecycle.addObserver(eventObserver)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(eventObserver)
        }
    })
    ContactsScreenContent(navHostController, permissionState)
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun ContactsScreenContent(
    navHostController: NavHostController? = null,
    permissionState: PermissionState? = null
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Contacts")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navHostController?.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {

        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
@Preview
fun ContactsScreenPreview() {
    ContactsScreenContent()
}