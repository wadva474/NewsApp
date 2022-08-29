package com.wadud.news.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wadud.news.data.remote.dto.SourceDto

@Entity
class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0 ,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String
)