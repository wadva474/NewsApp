package com.wadud.news.domain.repository

import com.wadud.news.domain.model.Article
import com.wadud.news.util.Resource
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    suspend fun getArticles(
        fetchFromRemote : Boolean
    ) : Flow<Resource<List<Article>>>
}