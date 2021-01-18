package io.github.thang86.themovie.view.fragment.homefragment

import io.github.thang86.themovie.base.BaseContract
import io.github.thang86.themovie.data.local.entity.DataRoom


/**
 *
 * Created by Thang86
 */
interface HomeContract : BaseContract {
    fun onDataChange(data: List<DataRoom>)
    interface HomePresenterView {
        fun getApi()
    }
}
