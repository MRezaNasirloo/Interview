package com.mrezanasirloo.interview.domain

import com.mrezanasirloo.interview.domain.model.ResponseDomain
import io.reactivex.Single

abstract class UseCaseGetPhotos : UseCase<String, Single<ResponseDomain>>()