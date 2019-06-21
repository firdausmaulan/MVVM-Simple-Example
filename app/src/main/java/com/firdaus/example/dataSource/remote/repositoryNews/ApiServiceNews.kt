package com.firdaus.example.dataSource.remote.repositoryNews

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.firdaus.example.BuildConfig
import com.firdaus.example.base.BaseApp
import com.firdaus.example.model.news.News
import com.firdaus.example.utils.Constans
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.readystatesoftware.chuck.ChuckInterceptor
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface ApiServiceNews {

    companion object Factory {
        fun create(): ApiServiceNews {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL_NEWS)

            val client = OkHttpClient.Builder()
                .writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)

            if (BuildConfig.DEBUG) {
                client.addInterceptor(ChuckInterceptor(BaseApp.context))
                client.addInterceptor(StethoInterceptor())
            }

            client.addInterceptor { chain ->
                var request = chain.request()
                val url = request.url().newBuilder()
                    .addQueryParameter("country", Constans.COUNTRY)
                    .addQueryParameter("apiKey", BuildConfig.API_KEY)
                    .build()
                request = request.newBuilder().url(url).build()
                chain.proceed(request)
            }

            return retrofit.client(client.build()).build().create(ApiServiceNews::class.java)
        }
    }


    @GET("top-headlines")
    fun topHeadlines(@Query("page") page: Int?): Single<News>

}