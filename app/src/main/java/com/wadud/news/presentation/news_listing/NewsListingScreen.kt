package com.wadud.news.presentation.news_listing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.wadud.news.R
import com.wadud.news.util.CustomTabUtil

@Composable
fun NewsListingScreen(
    viewModel: NewsListingViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = viewModel.state.isRefreshing)
    val state = viewModel.state

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.top_news),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = {
                viewModel.onEvent(NewsListingEvent.Refresh)
            }
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.articles) { article ->
                    NewsItem(article) {
                        CustomTabUtil.launch(context, article.url)
                    }
                }
            }
        }
    }

}