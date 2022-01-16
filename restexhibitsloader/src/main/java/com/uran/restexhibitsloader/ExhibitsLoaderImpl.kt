package com.uran.restexhibitsloader

import com.uran.model.Exhibit
import com.uran.model.ExhibitsLoader
import com.uran.restexhibitsloader.network.ApiFactory

/*
 * @created 16/01/2022 - 4:57 PM
 * @author Ali Babayev
 * @github www.github.com/alibabayev0
*/
// It would be better to use different places and folder structured.
class ExhibitsLoaderImpl() : ExhibitsLoader {
    override suspend fun getExhibitList(): List<Exhibit> {
        // It would be better to use Result.kt which is provided by Google to catch exception, in upper level.
        // For the current task conditions, i did not add any additional conditions or lines.
        // Here it would be better to log all exceptions with Sentry (Exception Monitoring Service) or Timber(Logcat)
        // And use DI to avoid calling static fields.
        return try {
            ApiFactory.exhibitsLoader.getExhibitList()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
