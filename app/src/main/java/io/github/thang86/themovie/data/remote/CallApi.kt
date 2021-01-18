package io.github.thang86.themovie.data.remote


import io.github.thang86.themovie.data.local.model.CommonData
import io.github.thang86.themovie.data.local.model.Data
import io.github.thang86.themovie.data.local.model.NowMovie
import retrofit2.Call
import retrofit2.http.*

/**
 *
 * Created by Thang86
 */
@JvmSuppressWildcards
interface CallApi {
    @GET("api")
    fun getList(): Call<CommonData<Data>>

    @FormUrlEncoded
    @POST("api")
    fun listMore(): Call<CommonData<Data>>

    @GET("/3/movie/now_playing")
    fun getNowPlayingMovie(@QueryMap params:MutableMap<String,String>): Call<NowMovie>
}
