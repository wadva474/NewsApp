package com.wadud.news.data.mapper

import com.wadud.news.data.local.ArticleEntity
import com.wadud.news.data.remote.dto.ArticleDto
import com.wadud.news.domain.model.Article

fun ArticleEntity.toArticle() =
    Article(author, content, description, publishedAt, title, url, urlToImage)

fun Article.toArticleEntity() = ArticleEntity(
    author = author,
    content = content,
    description = description,
    publishedAt = publishedAt,
    title = title,
    url = url,
    urlToImage = urlToImage
)


fun ArticleDto.toArticle() = Article(
    author = author.orEmpty(),
    content = content.orEmpty(),
    description = description.orEmpty(),
    publishedAt = publishedAt,
    title = title,
    url = url,
    urlToImage = urlToImage.orEmpty()
)

fun ArticleDto.toArticleEntity() = ArticleEntity(
    author = author.orEmpty(),
    content = content.orEmpty(),
    description = description.orEmpty(),
    publishedAt = publishedAt,
    title = title,
    url = url,
    urlToImage = urlToImage.orEmpty()
)