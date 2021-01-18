package io.github.thang86.themovie.view.activity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import io.github.thang86.themovie.base.BaseActivity
import io.github.thang86.themovie.R
import io.github.thang86.themovie.data.local.model.Data
import io.github.thang86.themovie.view.fragment.homefragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.view.*

/**
 *
 * Created by Thang86
 */
class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var item: Data? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main)
        setSupportActionBar(appBar?.toolbar)
        item = ViewModelProviders.of(this).get(Data::class.java)

        appBar?.fab?.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this,drawer_layout, appBar?.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout?.addDrawerListener(toggle)
        toggle.syncState()

        nav_view?.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout!!.isDrawerOpen(GravityCompat.START)) {
            drawer_layout?.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun setItem(it: String) {
        item?.example = it
    }

    fun getItem(): String {
        return item!!.example
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                addFragment(HomeFragment())
            }
            R.id.nav_gallery -> {
//                addFragment(About())

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout?.closeDrawer(GravityCompat.START)
        return true
    }
}
