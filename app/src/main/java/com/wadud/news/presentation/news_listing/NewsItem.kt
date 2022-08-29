package com.wadud.news.presentation.news_listing

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.wadud.news.R
import com.wadud.news.domain.model.Article

@Composable
fun NewsItem(article: Article, modifier: Modifier = Modifier, onClick: (String) -> Unit) {
    val shape = RoundedCornerShape(
        topStartPercent = 10,
        bottomEndPercent = 10,
        topEndPercent = 10,
        bottomStartPercent = 10
    )
    Surface(
        modifier = modifier.fillMaxWidth().height(200.dp).padding(12.dp).clickable {
            onClick(article.url)
        },
        shape = shape
    ) {
        Box(Modifier.fillMaxWidth().fillMaxHeight()) {
            AsyncImage(
                model = article.urlToImage,
                contentDescription = stringResource(R.string.news_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = modifier.fillMaxSize().padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = modifier.fillMaxWidth().padding(4.dp)
                ) {
                    Text(
                        text = article.title,
                        style = MaterialTheme.typography.body2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colors.onBackground
                    )
                    Text(
                        text = article.author,
                        style = MaterialTheme.typography.caption,
                        maxLines = 1,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            }
        }
    }
}