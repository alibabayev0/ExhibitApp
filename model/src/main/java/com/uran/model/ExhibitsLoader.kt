package com.uran.model

import retrofit2.http.GET

/*
 * @created 16/01/2022 - 4:30 PM
 * @author Ali Babayev
 * @github www.github.com/alibabayev0
*/
interface ExhibitsLoader {
    // It would be better if we use suspend function here.
    @GET("list")
    suspend fun getExhibitList(): List<Exhibit>
}
