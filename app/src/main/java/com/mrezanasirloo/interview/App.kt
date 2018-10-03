package com.mrezanasirloo.interview

import android.app.Application
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    companion object {
        val baseUrl: String by lazy {
            "https@ //www.lenzor.com/etc/api"
        }

        val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

    }

    override fun onCreate() {
        super.onCreate()
    }
}