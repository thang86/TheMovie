package io.github.thang86.themovie.view.fragment.homefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.blankj.utilcode.util.LogUtils
import io.github.thang86.themovie.base.BaseFragment
import io.github.thang86.themovie.data.local.entity.DataRoom
import io.github.thang86.themovie.data.local.room.livedata.MyViewModel
import io.github.thang86.themovie.R
import io.github.thang86.themovie.utils.observe.AutoDisposable
import io.github.thang86.themovie.utils.observe.ObserveEasy
import kotlinx.android.synthetic.main.home_fragment.*

/**
 *
 * Created by Thang86
 */
class HomeFragment : BaseFragment(), HomeContract {
//    private val db: MyViewModel by lazy{ ViewModelProviders.of(this).get(MyViewModel::class.java) }
    private val presenter: HomePresenter by lazy { HomePresenter(this) }
    private val autodis = AutoDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autodis.bindTo(this.lifecycle)
    }

    override fun setView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
//        lifecycle.addObserver(presenter)
//        button.setOnClickListener({ view1 -> db.insert(DataRoom("test", 1)) })

//        db.allData.observe(this, Observer<List<DataRoom>> { this.onDataChange(it) })
        presenter.getApi()
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

    override fun onLoading() {

    }

    override fun onLoadComplete() {

    }

    override fun onError(mess: String) {

//        Toast.makeText(App.applicationContext(), "" + SharedPrefs.instance?.get("keyObj", DataMain::class.java), Toast.LENGTH_SHORT).show()

    }


    override fun onDataChange(data: List<DataRoom>) {
        LogUtils.a(data.size)
        button?.setText(data.size.toString() + "")
        mContext()!!.setItem(data.size.toString() + "")
//        val item = DataMain("test2", 1)
//        SharedPrefs.instance?.put("keyObj", item)

    }

    override fun onDestroy() {
        super.onDestroy()
//        lifecycle.removeObserver(presenter)
    }
}
