package com.uran.restexhibitsloader.network

import com.google.gson.GsonBuilder
import com.uran.model.ExhibitsLoader
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.uran.restexhibitsloader.BuildConfig
/*
 * @created 16/01/2022 - 5:25 PM
 * @author Ali Babayev
 * @github www.github.com/alibabayev0
*/

// For current task conditions, i made small fake DI, which we provide Retrofit client just with one function.
// and create ExhibitLoader. In the task, did not write anything else, that is why, i avoid to use more complex staffs in this
// small task
object ApiFactory {
    private fun provideBaseUrl(): String {
        return BuildConfig.DOMAIN + "Reyst/exhibit_db/"
    }

    private fun provideRetrofit(): Retrofit {
        val gson = GsonBuilder().create()

        val logging = HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(provideBaseUrl())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val exhibitsLoader: ExhibitsLoader = provideRetrofit().create(ExhibitsLoader::class.java)
}
