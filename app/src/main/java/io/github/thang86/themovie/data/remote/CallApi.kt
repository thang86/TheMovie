package io.github.thang86.themovie.data.remote


import io.github.thang86.themovie.data.local.model.CommonData
import io.github.thang86.themovie.data.local.model.Data
import io.github.thang86.themovie.data.local.model.MostPopular
import io.github.thang86.themovie.data.local.model.NowMovie
import io.github.thang86.themovie.data.local.model.detail.MovieDetail
import retrofit2.Call
import retrofit2.http.*

/**
 *
 * Created by Thang86
 */
@JvmSuppressWildcards
interface CallApi {
    @GET("/3/movie/now_playing")
    fun getNowPlayingMovie(@QueryMap params: MutableMap<String, String>): Call<NowMovie>

    @GET("/3/movie/popular")
    fun getMostPopular(@Query("api_key") apiKey: String): Call<MostPopular>

    // https://api.themoviedb.org/3/movie/{MOVIE_ID}?api_key={YOUR_KEY}
    @GET("/3/movie/{id}")
    fun getDetailMovie(@Path("id") id: String,
                       @Query("api_key") apiKey: String): Call<MovieDetail>
}
