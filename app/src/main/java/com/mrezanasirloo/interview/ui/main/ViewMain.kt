package com.mrezanasirloo.interview.ui.main

import com.mrezanasirloo.interview.domain.model.PhotoItemDomain

interface ViewMain {
    fun updateList(list: List<PhotoItemDomain>)
    fun error(error: Throwable?)

}
