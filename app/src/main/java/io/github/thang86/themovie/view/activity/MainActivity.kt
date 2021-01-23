package io.github.thang86.themovie.view.activity

import android.os.Bundle
import io.github.thang86.themovie.R
import io.github.thang86.themovie.base.BaseActivity

/**
 *
 * Created by Thang86
 */
class MainActivity : BaseActivity() {

//    private var item: Data? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main)

    }


//    fun setItem(it: String) {
//        item?.example = it
//    }
//
//    fun getItem(): String {
//        return item!!.example
//    }

}
