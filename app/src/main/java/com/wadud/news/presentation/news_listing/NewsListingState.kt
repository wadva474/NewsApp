package com.wadud.news.presentation.news_listing

import com.wadud.news.domain.model.Article

data class NewsListingState(
    val articles : List<Article> = emptyList(),
    val isLoading : Boolean = false,
    val isRefreshing : Boolean = false,

)