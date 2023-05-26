package com.project.livechat.ui.screens.contacts

import android.Manifest
import android.app.Activity
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavHostController
import com.project.livechat.ui.utils.getMultiplePermissionsLauncher
import com.project.livechat.ui.utils.openAppSettings
import com.project.livechat.ui.viewmodels.PermissionViewModel
import com.project.livechat.ui.widgets.ContactsPermissionTextProvider
import com.project.livechat.ui.widgets.PermissionDialog

@Composable
fun ContactsScreen(
    navHostController: NavHostController,
    backPressedDispatcher: OnBackPressedDispatcher,
    permissionViewModel: PermissionViewModel
) {
    val permissionsToRequest = arrayOf(Manifest.permission.READ_CONTACTS)
    val dialogQueue = permissionViewModel.visiblePermissionDialogQueue
    val multiplePermissionResultLauncher =
        getMultiplePermissionsLauncher(permissionsToRequest, permissionViewModel)
    val lifecycleOwner = LocalLifecycleOwner.current
    val activity = LocalContext.current as Activity

    DisposableEffect(key1 = lifecycleOwner, effect = {
        val eventObserver = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    multiplePermissionResultLauncher.launch(permissionsToRequest)
                }

                else -> Unit
            }
        }
        lifecycleOwner.lifecycle.addObserver(eventObserver)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(eventObserver)
        }
    })

    ContactsScreenContent(navHostController)

    dialogQueue.reversed().forEach { permission ->
        PermissionDialog(
            permissionTextProvider = when (permission) {
                Manifest.permission.READ_CONTACTS -> {
                    ContactsPermissionTextProvider()
                }

                else -> return@forEach
            },
            isPermanentlyDeclined = !shouldShowRequestPermissionRationale(
                activity,
                permission
            ),
            onDismiss = permissionViewModel::dismissDialog,
            onOkClick = {
                permissionViewModel.dismissDialog()

            },
            onGoToAppSettingsClick = {
                activity.openAppSettings()
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsScreenContent(
    navHostController: NavHostController? = null,
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

@Composable
@Preview
fun ContactsScreenPreview() {
    ContactsScreenContent()
}