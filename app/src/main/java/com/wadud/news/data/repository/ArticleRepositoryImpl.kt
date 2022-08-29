package com.wadud.news.data.repository

import android.util.Log
import com.wadud.news.BuildConfig
import com.wadud.news.data.local.dao.ArticleDao
import com.wadud.news.data.mapper.toArticle
import com.wadud.news.data.mapper.toArticleEntity
import com.wadud.news.data.remote.NewsAPI
import com.wadud.news.domain.model.Article
import com.wadud.news.domain.repository.ArticleRepository
import com.wadud.news.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepositoryImpl @Inject constructor(
    private val api: NewsAPI,
    private val articleDao: ArticleDao
) : ArticleRepository {
    override suspend fun getArticles(
        fetchFromRemote: Boolean
    ): Flow<Resource<List<Article>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListing = articleDao.getAllArticles()
            emit(Resource.Success(data = localListing.map { it.toArticle() }))

            val isDbEmpty = localListing.isEmpty()

            val shouldLoadFromCache = !isDbEmpty && !fetchFromRemote

            if (shouldLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteListing = try {
                api.getTopHeadLines("us", BuildConfig.API_KEY).articles
            } catch (exception: Exception) {
                exception.printStackTrace()
                Log.e("wadud",exception.toString())
                emit(Resource.Error("Error while Loading Data"))
                null
            }

            remoteListing?.let { articles ->
                articleDao.clearArticles()
                articleDao.insertArticles(articles.map {
                    it.toArticleEntity()
                })
                emit(Resource.Success(articleDao.getAllArticles().map {
                    it.toArticle()
                }))
                emit(Resource.Loading(false))
            }

        }
    }

}