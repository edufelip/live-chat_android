package com.project.livechat.ui.screens.home.behavior

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeTabFilterBehavior @OptIn(ExperimentalFoundationApi::class) constructor(
    private val pagerState: PagerState,
    private val scope: CoroutineScope,
    private val index: Int
) : HomeTabBehavior() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun execute() {
        scope.launch {
            pagerState.animateScrollToPage(index)
        }
    }
}