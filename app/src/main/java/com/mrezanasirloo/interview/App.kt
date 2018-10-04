package com.mrezanasirloo.interview

import android.app.Application
import com.mrezanasirloo.data.network.ApiLenzor
import com.squareup.picasso.Picasso
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    companion object {
        val baseUrl: String by lazy {
            "https://www.lenzor.com/etc/api/"
        }

        val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        val api: ApiLenzor by lazy {
            retrofit.create(ApiLenzor::class.java)
        }

    }

    override fun onCreate() {
        super.onCreate()

        val picasso = Picasso.Builder(this)
                .loggingEnabled(BuildConfig.DEBUG)
//                .indicatorsEnabled(BuildConfig.DEBUG)
                .build()
        Picasso.setSingletonInstance(picasso)
    }
}