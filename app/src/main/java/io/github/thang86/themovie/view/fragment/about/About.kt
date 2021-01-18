package io.github.thang86.themovie.view.fragment.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blankj.utilcode.util.LogUtils
import io.github.thang86.themovie.base.BaseFragment
import io.github.thang86.themovie.R
import io.github.thang86.themovie.utils.observe.AutoDisposable
import io.github.thang86.themovie.utils.observe.ObserveEasy
import kotlinx.android.synthetic.main.about_fragment.*

/**
 *
 * Created by Thang86
 */
class About : BaseFragment(), AboutContract {
    private val autodis = AutoDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autodis.bindTo(this.lifecycle)

    }
    override fun setView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        return inflater.inflate(R.layout.about_fragment, container, false)
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {

        lifecycle.addObserver(AboutPresenter.instance.setCallback(this))
        title.setText(mContext()!!.getItem())

        object : ObserveEasy(){
            override fun getDispose(): AutoDisposable? {
                return autodis
            }

            override fun doBackground(): Any? {

                return null
            }

            override fun onFail(err: String) {
                super.onFail(err)
            }

            override fun onLoadComplete() {
                super.onLoadComplete()
            }

            override fun onLoading() {
                super.onLoading()
            }

            override fun onSuccess(result: Any?) {
                super.onSuccess(result)
            }

        }
    }

    override fun inCreate() {
        LogUtils.a("inCreate")
    }

    override fun inResume() {
        LogUtils.a("in inResume")


    }

    override fun indestroy() {
        LogUtils.a("in indestroy")

    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(AboutPresenter.instance)
    }
}
