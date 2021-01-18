package io.github.thang86.themovie.data.local.room.livedata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import io.github.thang86.themovie.data.local.entity.DataRoom

/**
 *
 * Created by Thang86
 */
class MyViewModel(application: Application) : AndroidViewModel(application) {
    private val mRepository: WorkRepository

    val allData: LiveData<List<DataRoom>>

    init {
        mRepository = WorkRepository(application)
        allData = mRepository.allData
    }

    fun insert(word: DataRoom) {
        mRepository.insert(word)
    }
}
