package io.github.thang86.themovie.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import io.github.thang86.themovie.App

/**
 *
 * Created by Thang86
 */
object NetwortUtils {

    @SuppressLint("ServiceCast")
    fun hasNetwork(): Boolean? {
        var isConnected: Boolean? = false
        val connectivityManager =
            App.applicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }
}