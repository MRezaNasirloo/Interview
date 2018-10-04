package com.mrezanasirloo.data.network

import com.mrezanasirloo.data.network.model.Response
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiLenzor {
    @GET("photolistbytop/{nextPage}")
    fun photos(@Path("nextPage", encoded = true) nextPage: String): Single<Response>
}
