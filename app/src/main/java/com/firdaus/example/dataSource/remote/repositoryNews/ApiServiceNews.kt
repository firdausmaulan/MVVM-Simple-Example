package com.firdaus.example.dataSource.remote.repositoryNews

import com.firdaus.example.BuildConfig
import com.firdaus.example.base.BaseApp
import com.firdaus.example.model.news.News
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.readystatesoftware.chuck.ChuckInterceptor
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceNews {

    companion object Factory {
        fun create(): ApiServiceNews {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL_NEWS)

            val client = OkHttpClient.Builder()

            if (BuildConfig.DEBUG) client.addInterceptor(ChuckInterceptor(BaseApp.context))

            client.addInterceptor { chain ->
                var request = chain.request()
                val url = request.url().newBuilder()
                    .addQueryParameter("q", "tech")
                    .addQueryParameter("sortBy", "publishedAt")
                    .addQueryParameter("apiKey", BuildConfig.API_KEY)
                    .build()
                request = request.newBuilder().url(url).build()
                chain.proceed(request)
            }

            return retrofit.client(client.build()).build().create(ApiServiceNews::class.java)
        }
    }


    @GET("everything")
    fun requestNews(@Query("page") page: Int?): Single<News>

}