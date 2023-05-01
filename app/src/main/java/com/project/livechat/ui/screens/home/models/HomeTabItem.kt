package com.project.livechat.ui.screens.home.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.project.livechat.ui.screens.home.behavior.HomeTabCategory

class HomeTabItem(
    val text: String?,
    val icon: ImageVector = Icons.Outlined.Person,
    val behavior: HomeTabCategory = HomeTabCategory.FILTER
)

val homeTabItemList = listOf(
    HomeTabItem(
        text = "All",
    ),
    HomeTabItem(
        text = "College",
    ),
    HomeTabItem(
        text = null,
        icon = Icons.Default.Add,
        behavior = HomeTabCategory.ADD
    )
)