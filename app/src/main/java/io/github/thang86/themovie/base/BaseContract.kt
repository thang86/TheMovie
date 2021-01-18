package io.github.thang86.themovie.base

/**
 *
 * Created by Thang86
 */
interface BaseContract : BaseView {
    fun onLoading()
    fun onLoadComplete()
    fun onError(mess: String)
}
