package io.github.thang86.themovie.view.fragment.detail

import io.github.thang86.themovie.base.BaseContract
import io.github.thang86.themovie.data.local.model.Result
import io.github.thang86.themovie.data.local.model.detail.MovieDetail

/**
 *
 * Created by Thang86
 */
interface DetailContract:BaseContract {
    fun onFetchDetailMovieSuccess(movie: MovieDetail)
    interface DetailPresenterView {
        fun fetchApiDetailMovie(movieId:String)
    }
}