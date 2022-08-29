package com.wadud.news.data.repository

import com.wadud.news.domain.model.Article
import com.wadud.news.domain.repository.ArticleRepository
import com.wadud.news.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeArticleRepository : ArticleRepository {

    private val articles = mutableListOf<Article>()

    override suspend fun getArticles(fetchFromRemote: Boolean): Flow<Resource<List<Article>>> {
        articles.addAll(
            listOf(
                Article(
                    "wadud",
                    "This is stale news",
                    "first inserted",
                    "Nigeria CNN",
                    "fun",
                    url = "Jump",
                    urlToImage = "http:://image.sample.co"
                )
            )
        )
        return flow {
            Resource.Success(data = articles)
        }
    }
}