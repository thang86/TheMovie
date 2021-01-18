package io.github.thang86.themovie.data.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.github.thang86.themovie.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * Created by Thang86
 */
object ApiUtil {
    fun createApi(): CallApi {
        return ServiceGenerator.createService(CallApi::class.java)
    }

    fun createApiOther(): CallApi {
        val builder = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
        return builder.build().create(CallApi::class.java)
    }

    fun createTokenApi(): CallApi {
        return ServiceGenerator.createServiceToken(CallApi::class.java)
    }
}
