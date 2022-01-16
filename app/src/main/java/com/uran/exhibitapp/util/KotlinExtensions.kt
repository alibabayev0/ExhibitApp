package com.uran.exhibitapp.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

/*
 * @created 16/01/2022 - 3:51 PM
 * @author Ali Babayev
 * @github www.github.com/alibabayev0
*/
fun ImageView.loadImageFromNetwork(
    imgUrlSuffix: String?,
    onSuccess: () -> Unit = {},
    onError: () -> Unit = {},
) {
    Glide.with(this.context)
        .load(imgUrlSuffix)
        .centerInside()
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                onError()
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                onSuccess()
                return false
            }
        })
        .into(this)
}
