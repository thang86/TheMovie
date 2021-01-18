package io.github.thang86.themovie.view.fragment.homefragment

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.github.thang86.themovie.BuildConfig
import io.github.thang86.themovie.data.local.model.CommonData
import io.github.thang86.themovie.data.local.model.Data
import io.github.thang86.themovie.data.local.model.NowMovie
import io.github.thang86.themovie.data.remote.ApiUtil
import io.github.thang86.themovie.data.remote.BaseInteractor
import io.github.thang86.themovie.data.remote.CallApi
import io.github.thang86.themovie.data.remote.customcallback.BaseRetrofit
import retrofit2.Response

/**
 *
 * Created by Thang86
 */
class HomePresenter(val v: HomeContract) : BaseInteractor(), LifecycleObserver, HomeContract.HomePresenterView {

    override fun callAPi(): CallApi {
        return ApiUtil.createApi()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    override fun getApi() {

        // init param when fetch now playing movie from server
        var param = mutableMapOf<String,String>()
        param["language"] = "en-US"
        param["page"] = "1"
        param["api_key"] = BuildConfig.API_KEY



        object : BaseRetrofit<NowMovie>(callAPi().getNowPlayingMovie(param), v) {


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

            override fun onGetApiComplete(response: Response<NowMovie>) {

                Log.d("Thang86",""+response.body()?.totalResults)
            }
        }
    }


}
