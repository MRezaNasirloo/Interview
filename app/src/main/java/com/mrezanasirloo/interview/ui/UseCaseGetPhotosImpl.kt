package com.mrezanasirloo.interview.ui

import com.mrezanasirloo.data.network.ApiLenzor
import com.mrezanasirloo.interview.domain.UseCaseGetPhotos
import com.mrezanasirloo.interview.domain.model.PhotolistbytopItemDomain
import com.mrezanasirloo.interview.domain.model.ResponseDomain
import io.reactivex.Single

class UseCaseGetPhotosImpl(private val api: ApiLenzor): UseCaseGetPhotos() {
    override fun execute(parameter: Unit): Single<ResponseDomain> {
        return api.images()
                .map { response ->
                    ResponseDomain(
                            response.photolistbytop.map { PhotolistbytopItemDomain(
                                    it.senderImgSrc,
                                    it.title,
                                    it.imgSrcM,
                                    it.senderName,
                                    it.imgSrcS
                            ) }
                    )
                }
    }
}