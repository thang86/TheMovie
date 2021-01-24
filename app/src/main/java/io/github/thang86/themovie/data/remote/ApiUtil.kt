package io.github.thang86.themovie.data.remote

/**
 *
 * Created by Thang86
 */
object ApiUtil {
    fun createApi(): CallApi {
        return ServiceGenerator.createService(CallApi::class.java)
    }
}
