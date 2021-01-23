package io.github.thang86.themovie.view.fragment.detail

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import io.github.thang86.themovie.BuildConfig
import io.github.thang86.themovie.data.local.model.MostPopular
import io.github.thang86.themovie.data.local.model.detail.MovieDetail
import io.github.thang86.themovie.data.remote.ApiUtil
import io.github.thang86.themovie.data.remote.BaseInteractor
import io.github.thang86.themovie.data.remote.CallApi
import io.github.thang86.themovie.data.remote.customcallback.BaseRetrofit
import retrofit2.Response

/**
 *
 * Created by Thang86
 */
class DetailPresenter(val v: DetailContract) : BaseInteractor(), LifecycleObserver,
    DetailContract.DetailPresenterView {
    override fun callAPi(): CallApi {
        return ApiUtil.createApi()
    }

    override fun fetchApiDetailMovie(movieId: String) {

        object :
            BaseRetrofit<MovieDetail>(callAPi().getDetailMovie(movieId, BuildConfig.API_KEY), v) {


            override fun onFail(err: String) {
                v.onError(err)
            }

            override fun onLoading() {
                super.onLoading()
                v.onLoading()
            }

            override fun onLoadComplete() {
                super.onLoadComplete()
                v.onLoadComplete()
            }


            override fun onGetApiComplete(response: Response<MovieDetail>) {
                response.body()?.let { v.onFetchDetailMovieSuccess(it) }
            }
        }
    }


}