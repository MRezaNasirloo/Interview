package com.mrezanasirloo.interview.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.mrezanasirloo.interview.Switch
import com.mrezanasirloo.interview.domain.UseCaseGetPhotos
import com.mrezanasirloo.interview.domain.model.PhotoItemDomain
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable

/**
 * @author : M.Reza.Nasirloo@gmail.com
 *         Created on: 2018-10-04
 */
class ViewModelMain(
        private val main: Scheduler,
        private val io: Scheduler,
        private val useCaseGetPhotosImpl: UseCaseGetPhotos
) : ViewModel() {

    val state: MutableLiveData<StateMain> = MutableLiveData()
    private var disposable = CompositeDisposable()

    init {
        state.value = StateMain()
    }

    fun loadFirstPageIfNotLoading() {
        val d = state.value?.run {
            if (isLoading || items.isNotEmpty()) return
            useCaseGetPhotosImpl.execute("").toObservable()
                    .subscribeOn(io)
                    .observeOn(main)
                    .map { Actions.Loaded(items = it.photoListDomain, nextPage = it.nextPage) as Actions }
                    .onErrorReturn { Actions.Error(it) }
                    .startWith(Actions.Loading)
                    .subscribe {
                        state.value = it.update(this)
                    }
        }
        if (d != null) disposable.add(d)
    }

    fun loadNextPage() {
        val d = state.value?.run {
            if (isLoading) return
            useCaseGetPhotosImpl.execute(nextPage).toObservable()
                    .subscribeOn(io)
                    .observeOn(main)
                    .map { Actions.Loaded(items = it.photoListDomain, nextPage = it.nextPage) as Actions }
                    .onErrorReturn { Actions.Error(it) }
                    .startWith(Actions.Loading)
                    .subscribe {
                        state.value = it.update(this)
                    }
        }
        if (d != null) disposable.add(d)

    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}

data class StateMain(
        val items: List<PhotoItemDomain> = emptyList(),
        val nextPage: String = "",
        val isLoading: Boolean = false,
        val error: Switch<Throwable?> = Switch(null, null)
)

sealed class Actions {
    abstract fun update(state: StateMain): StateMain

    object Loading : Actions() {
        override fun update(state: StateMain): StateMain {
            return state.copy(isLoading = true)
        }
    }

    data class Loaded(val items: List<PhotoItemDomain> = emptyList(), val nextPage: String) : Actions() {
        override fun update(state: StateMain): StateMain {
            val newList = ArrayList(state.items)
            newList.addAll(items)
            return state.copy(items = newList, nextPage = nextPage, isLoading = false)
        }
    }

    data class Error(val error: Throwable? = null) : Actions() {
        override fun update(state: StateMain): StateMain {
            return state.copy(error = Switch(error, null), isLoading = false)
        }
    }
}
