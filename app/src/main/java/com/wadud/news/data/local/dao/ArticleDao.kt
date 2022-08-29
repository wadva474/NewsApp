package com.wadud.news.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wadud.news.data.local.ArticleEntity

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articlesListingEntity: List<ArticleEntity>)

    @Query("DELETE FROM articleentity")
    suspend fun clearArticles()

    @Query("SELECT * FROM articleentity")
    suspend fun getAllArticles() : List<ArticleEntity>

}