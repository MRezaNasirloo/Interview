package com.mrezanasirloo.data.network

import com.mrezanasirloo.data.network.model.Response
import io.reactivex.Single
import retrofit2.http.GET

interface ApiLenzor {
    @GET("photolistbytop")
    fun images(): Single<Response>
}
