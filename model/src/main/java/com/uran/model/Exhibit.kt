package com.uran.model

import com.google.gson.annotations.SerializedName

/*
 * @created 16/01/2022 - 4:30 PM
 * @author Ali Babayev
 * @github www.github.com/alibabayev0
*/
data class Exhibit(
    @SerializedName("title")
    val title: String,
    @SerializedName("images")
    val images: List<String>
)
