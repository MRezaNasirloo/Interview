package com.mrezanasirloo.interview.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import com.jakewharton.rxbinding2.support.v7.widget.RxRecyclerView
import com.mrezanasirloo.interview.App
import com.mrezanasirloo.interview.R
import com.mrezanasirloo.interview.usecase.UseCaseGetPhotosImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class ActivityMain : AppCompatActivity() {
    private val adapterPhotos = AdapterPhotos()

    private lateinit var viewModel: ViewModelMain

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        list.adapter = adapterPhotos
        viewModel = ViewModelProviders.of(this, object : ViewModelProvider.NewInstanceFactory() {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ViewModelMain(AndroidSchedulers.mainThread(), Schedulers.io(), UseCaseGetPhotosImpl(App.api)) as T
            }
        }).get(ViewModelMain::class.java)
        viewModel.state.observe(this, Observer { stateMain ->
            stateMain?.let {
                println("State: $it")
                adapterPhotos.update(it.items)
                error(it.error.value)
            }
        })

        viewModel.loadFirstPageIfNotLoading()

        disposable = RxRecyclerView.scrollEvents(list)
                .filter {
                    val layoutManager = list.layoutManager as StaggeredGridLayoutManager
                    val positions = layoutManager.findLastVisibleItemPositions(null)
                    layoutManager.itemCount < Math.max(positions[0], positions[1]) + 2
                }
                .cast(Any::class.java)
                .subscribe {
                    viewModel.loadNextPage()
                }

    }

    private fun error(error: Throwable?) {
        error?.let {
            Snackbar.make(list, it.message.toString(), Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
