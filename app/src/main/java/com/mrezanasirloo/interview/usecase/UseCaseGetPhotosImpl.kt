package com.mrezanasirloo.interview.usecase

import com.mrezanasirloo.data.network.ApiLenzor
import com.mrezanasirloo.interview.domain.UseCaseGetPhotos
import com.mrezanasirloo.interview.domain.model.PhotoItemDomain
import com.mrezanasirloo.interview.domain.model.ResponseDomain
import io.reactivex.Single

class UseCaseGetPhotosImpl(private val api: ApiLenzor) : UseCaseGetPhotos() {
    override fun execute(parameter: Unit): Single<ResponseDomain> {
        return api.images()
                .map { response ->
                    ResponseDomain(response.photolistbytop.map {
                        PhotoItemDomain(
                                it.senderName,
                                it.senderImgSrc,
                                it.title,
                                it.imgSrcL,
                                it.imgSrcM,
                                it.imgSrcS,
                                it.size.replace('X', ':')
                        )
                    }
                    )
                }
    }
}