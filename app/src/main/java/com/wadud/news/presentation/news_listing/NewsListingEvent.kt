package com.wadud.news.presentation.news_listing

sealed class NewsListingEvent {
    object Refresh : NewsListingEvent()
}