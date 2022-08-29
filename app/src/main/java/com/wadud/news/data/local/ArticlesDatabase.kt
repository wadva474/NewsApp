package com.wadud.news.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wadud.news.data.local.dao.ArticleDao


@Database(
    entities = [ArticleEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ArticlesDatabase : RoomDatabase() {
    abstract val articleDao: ArticleDao
}