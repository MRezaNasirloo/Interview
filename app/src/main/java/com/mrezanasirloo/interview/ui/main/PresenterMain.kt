package com.mrezanasirloo.interview.ui.main

import com.mrezanasirloo.interview.domain.UseCaseGetPhotos
import com.mrezanasirloo.interview.domain.model.PhotoItemDomain
import com.mrezanasirloo.slick.uni.PartialViewState
import com.mrezanasirloo.slick.uni.SlickPresenterUni
import io.reactivex.Scheduler

class PresenterMain(
        main: Scheduler,
        io: Scheduler,
        private val useCaseGetPhotosImpl: UseCaseGetPhotos
): SlickPresenterUni<ViewMain, StateMain>(main, io) {
    override fun start(view: ViewMain) {
        val photoList = useCaseGetPhotosImpl.execute(Unit).toObservable().subscribeOn(io)
                .map { UpdateListLoaded(it.photoListDomain) as PartialViewState<StateMain> }
                .startWith(UpdateListLoading())
                .onErrorReturn { UpdateListError(it) }

        subscribe(StateMain(), merge(photoList))
    }

    override fun render(state: StateMain, view: ViewMain) {
        println(state)
        view.updateList(state.items)
        view.error(state.error)
    }
}

data class StateMain(
        val items: List<PhotoItemDomain> = emptyList(),
        val isLoading: Boolean = false,
        val error: Throwable? = null
)

class UpdateListLoaded(private val items: List<PhotoItemDomain>): PartialViewState<StateMain>{
    override fun reduce(state: StateMain): StateMain {
        return state.copy(items = items, isLoading = false, error = null)
    }
}

class UpdateListLoading(): PartialViewState<StateMain> {
    override fun reduce(state: StateMain): StateMain {
        return state.copy(isLoading = true)
    }
}

class UpdateListError(private val error: Throwable?): PartialViewState<StateMain> {
    override fun reduce(state: StateMain): StateMain {
        return state.copy(isLoading = false, error = error)
    }
}
