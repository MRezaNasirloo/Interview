package com.mrezanasirloo.interview

import android.app.Application
import com.mrezanasirloo.data.network.ApiLenzor
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class App : Application() {
    companion object {
        val baseUrl: String by lazy {
            "https://www.lenzor.com//etc/api/"
        }

        val okHttpClient: OkHttpClient by lazy {
            OkHttpClient.Builder()
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                    .build()
        }

        val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
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
//                .loggingEnabled(BuildConfig.DEBUG)
//                .indicatorsEnabled(BuildConfig.DEBUG)
                .build()
        Picasso.setSingletonInstance(picasso)
    }
}