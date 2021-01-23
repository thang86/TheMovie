package io.github.thang86.themovie.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import io.github.thang86.themovie.R

/**
 *
 * Created by Thang86
 */
open class BaseActivity : AppCompatActivity(), BaseView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
    }


    override fun setErrorParent(data: Any) {

    }
}
