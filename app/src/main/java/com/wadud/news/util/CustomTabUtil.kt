package com.wadud.news.util

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import com.wadud.news.R

object CustomTabUtil {

    private var builder: CustomTabsIntent? = null

    fun launch(context: Context, url: String) {
        if (builder == null) {
            builder = CustomTabsIntent.Builder()
                .setDefaultColorSchemeParams(
                    CustomTabColorSchemeParams.Builder()
                        .setToolbarColor(R.color.black)
                        .build()
                )
                .setShowTitle(true)
                .setStartAnimations(
                    context,
                    R.anim.slide_in_right,
                    R.anim.slide_out_left
                )
                .setExitAnimations(
                    context,
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right
                )
                .build()
        }
        builder?.launchUrl(context, Uri.parse(url))
    }
}

