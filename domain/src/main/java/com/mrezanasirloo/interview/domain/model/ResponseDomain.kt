package com.mrezanasirloo.interview.domain.model

import java.util.Collections.emptyList

class ResponseDomain(
        val photoListDomain: List<PhotoItemDomain> = emptyList(),
        val nextPage: String = ""
)
