package com.wadud.news.presentation.news_listing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wadud.news.domain.repository.ArticleRepository
import com.wadud.news.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListingViewModel @Inject constructor(
    private val repository: ArticleRepository
) : ViewModel() {

    var state by mutableStateOf(NewsListingState())

    init {
        getArticles()
    }

    fun onEvent(event: NewsListingEvent) {
        when (event) {
            is NewsListingEvent.Refresh -> {
                getArticles(fetchFromRemote = true)
            }
        }
    }

     fun getArticles(fetchFromRemote: Boolean = false) {
        viewModelScope.launch {
            repository.getArticles(fetchFromRemote).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { articles ->
                            state = state.copy(articles = articles)
                        }
                    }
                    is Resource.Loading -> {
                        state = state.copy(isLoading = result.isLoading)
                    }
                    is Resource.Error -> {

                    }
                }
            }
        }
    }

}