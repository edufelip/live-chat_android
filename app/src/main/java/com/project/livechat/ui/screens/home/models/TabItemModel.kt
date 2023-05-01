package com.project.livechat.ui.screens.home.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.project.livechat.ui.screens.home.behavior.HomeTabCategory

class TabItemModel(
    val text: String?,
    val icon: ImageVector = Icons.Outlined.Person,
    val behavior: HomeTabCategory = HomeTabCategory.FILTER
)

val tabItemList = listOf(
    TabItemModel(
        text = "All",
    ),
    TabItemModel(
        text = "College",
    ),
    TabItemModel(
        text = null,
        icon = Icons.Default.Add,
        behavior = HomeTabCategory.ADD
    )
)