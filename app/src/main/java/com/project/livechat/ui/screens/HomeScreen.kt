package com.project.livechat.ui.screens

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.project.livechat.ui.utils.isIndexCurrent

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navHostController: NavHostController,
    backPressedDispatcher: OnBackPressedDispatcher
) {
    val pagerState = rememberPagerState()
    val list = listOf(
        "All" to Icons.Outlined.Person,
        "College" to Icons.Outlined.Person,
        "" to Icons.Outlined.Add
    )
    LaunchedEffect(key1 = Unit) {
//        val mAuth = FirebaseAuth.getInstance()
//        val currentUser = mAuth.currentUser
//        if (currentUser != null) Routes.AuthenticationRoute.navigate(navHostController)
    }
    HomeContent(itemList = list, pagerState = pagerState)
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeContent(itemList: List<Pair<String, ImageVector>>, pagerState: PagerState) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            Tabs(itemList = itemList, pagerState = pagerState)
            TabsContent(itemList = itemList, pagerState = pagerState)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs(itemList: List<Pair<String, ImageVector>>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    LazyRow(
        modifier = Modifier.padding(start = 8.dp)
    ) {
        itemsIndexed(itemList) { index, item ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = if (pagerState.isIndexCurrent(index)) MaterialTheme.colorScheme.primary else Color.Transparent,
                ),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                modifier = Modifier.padding(end = 8.dp)
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
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsContent(itemList: List<Pair<String, ImageVector>>, pagerState: PagerState) {
    HorizontalPager(pageCount = itemList.size, state = pagerState, userScrollEnabled = false) { page ->
        when (page) {
            0 -> Unit
        }
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomePreview() {
    val list = listOf(
        "All" to Icons.Outlined.Person,
        "College" to Icons.Outlined.Person,
        "" to Icons.Outlined.Add
    )
    val pagerState = rememberPagerState()
    HomeContent(itemList = list, pagerState = pagerState)
}