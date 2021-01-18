package io.github.thang86.themovie.data.local.room.livedata

import android.app.Application
import androidx.lifecycle.LiveData
import io.github.thang86.themovie.data.local.entity.DataRoom
import io.github.thang86.themovie.data.local.room.AppDatabase
import io.github.thang86.themovie.data.local.room.QueriesDao
import io.github.thang86.themovie.utils.observe.AutoDisposable
import io.github.thang86.themovie.utils.observe.ObserveEasy

/**
 *
 * Created by Thang86
 */
class WorkRepository internal constructor(application: Application) {
    private val mQueries: QueriesDao
    internal val allData: LiveData<List<DataRoom>>

    init {
        val db = AppDatabase.getAppDatabase(application)
        mQueries = db.queries()
        allData = mQueries.getAll()
    }

    fun insert(data: DataRoom) {
        object : ObserveEasy(){
            override fun doBackground(): Any? {
                mQueries.insertData(data)
                return false
            }
            override fun getDispose(): AutoDisposable? {
                return null
            }
        }
    }
}
