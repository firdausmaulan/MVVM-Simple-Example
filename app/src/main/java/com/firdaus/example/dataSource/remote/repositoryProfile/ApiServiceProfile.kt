package com.firdaus.example.dataSource.remote.repositoryProfile

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.firdaus.example.BuildConfig
import com.firdaus.example.base.BaseApp
import com.firdaus.example.model.profile.ProfileResponse
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.readystatesoftware.chuck.ChuckInterceptor
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServiceProfile {

    companion object Factory {
        fun create(): ApiServiceProfile {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL_PROFILE)

            val client = OkHttpClient.Builder()

            if (BuildConfig.DEBUG) {
                client.addInterceptor(ChuckInterceptor(BaseApp.context))
                client.addInterceptor(StethoInterceptor())
            }

            return retrofit.client(client.build()).build().create(ApiServiceProfile::class.java)
        }
    }


    @GET("test/profile")
    fun requestProfile(): Single<ProfileResponse>

}