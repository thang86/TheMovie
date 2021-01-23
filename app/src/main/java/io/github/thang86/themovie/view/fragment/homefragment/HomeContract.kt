package io.github.thang86.themovie.view.fragment.homefragment

import io.github.thang86.themovie.base.BaseContract
import io.github.thang86.themovie.data.local.entity.DataRoom
import io.github.thang86.themovie.data.local.model.Result


/**
 *
 * Created by Thang86
 */
interface HomeContract : BaseContract {
    fun onDataChange(data: List<DataRoom>)
    fun onFetchMovieSuccess(movie:List<Result>)
    fun onFetchMostPopularSuccess(movie:List<Result>)
    interface HomePresenterView {
        fun fetchApiNowPlayingMovie()
        fun fetchApiMostPopular()

    }
}
