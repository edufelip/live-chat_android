package com.project.livechat.ui.screens.home.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.project.livechat.ui.utils.isIndexCurrent

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabItem(
    pagerState: PagerState,
    index: Int,
    item: Pair<String, ImageVector>,
    onItemClick: (index: Int) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (pagerState.isIndexCurrent(index)) MaterialTheme.colorScheme.primary else Color.Transparent,
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        modifier = Modifier.padding(end = 8.dp).clickable {
            onItemClick.invoke(index)
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 8.dp, top = 8.dp, start = 8.dp, end = if (item.first.isNotBlank()) 12.dp else 8.dp),
        ) {
            Icon(
                imageVector = item.second,
                tint = if (pagerState.isIndexCurrent(index)) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary,
                contentDescription = null
            )
            Text(
                text = item.first,
                color = if (pagerState.isIndexCurrent(index)) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
            )
        }
    }
}