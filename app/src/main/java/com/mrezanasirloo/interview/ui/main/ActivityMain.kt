package com.mrezanasirloo.interview.ui.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.mrezanasirloo.interview.App
import com.mrezanasirloo.interview.R
import com.mrezanasirloo.interview.domain.model.PhotoItemDomain
import com.mrezanasirloo.interview.usecase.UseCaseGetPhotosImpl
import com.mrezanasirloo.slick.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class ActivityMain : AppCompatActivity(), ViewMain {
    @Presenter
    lateinit var presenterMain: PresenterMain

    private val adapterPhotos = AdapterPhotos()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PresenterMain_Slick.bind(this, AndroidSchedulers.mainThread(), Schedulers.io(), UseCaseGetPhotosImpl(App.api))

        list.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        list.adapter = adapterPhotos
    }

    override fun updateList(list: List<PhotoItemDomain>) {
        adapterPhotos.update(list)
    }


    override fun error(error: Throwable?) {
        error?.let {
            Snackbar.make(list, it.message.toString(), Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_activity_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
