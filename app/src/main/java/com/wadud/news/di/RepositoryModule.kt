package com.wadud.news.di

import com.wadud.news.data.repository.ArticleRepositoryImpl
import com.wadud.news.domain.repository.ArticleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindArticleRepository(articleRepository: ArticleRepositoryImpl): ArticleRepository
}