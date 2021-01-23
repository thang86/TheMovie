package io.github.thang86.themovie.view.fragment.homefragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.LogUtils
import io.github.thang86.themovie.base.BaseFragment
import io.github.thang86.themovie.data.local.entity.DataRoom
import io.github.thang86.themovie.R
import io.github.thang86.themovie.data.local.model.Result
import io.github.thang86.themovie.utils.Common
import io.github.thang86.themovie.utils.observe.AutoDisposable
import io.github.thang86.themovie.view.fragment.homefragment.adapter.MostPopularAdapter
import io.github.thang86.themovie.view.fragment.homefragment.adapter.NowMovieAdapter
import io.github.thang86.themovie.view.fragment.homefragment.adapter.StartSnapHelper
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.partial_error_layout.*
import kotlinx.android.synthetic.main.partial_most_popular_movie.*
import kotlinx.android.synthetic.main.partial_movie_content.*
import kotlinx.android.synthetic.main.partial_now_playing_movie.*

/**
 *
 * Created by Thang86
 */

class HomeFragment : BaseFragment(), HomeContract, MostPopularAdapter.OnPopularClickListener {
    private val presenter: HomePresenter by lazy { HomePresenter(this) }
    private val autodis = AutoDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autodis.bindTo(this.lifecycle)
    }

    override fun setView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.home_fragment, container, false)


    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.fetchApiNowPlayingMovie()
        presenter.fetchApiMostPopular()

    }

    override fun onLoading() {
        partial_error_layout.visibility = View.GONE
        partial_movie_content.visibility = View.VISIBLE
        partial_loading_now_playing_movie.visibility = View.VISIBLE
        partial_now_playing_movie.visibility = View.GONE
        partial_loading_most_popular_movie.visibility = View.VISIBLE
        partial_most_popular_movie.visibility = View.GONE

    }

    override fun onLoadComplete() {


        partial_loading_now_playing_movie.visibility = View.GONE
        partial_now_playing_movie.visibility = View.VISIBLE
        partial_loading_most_popular_movie.visibility = View.GONE
        partial_most_popular_movie.visibility = View.VISIBLE
    }

    override fun onError(mess: String) {
//        Log.d("ThangERRR", mess)
        partial_error_layout.visibility = View.VISIBLE
        partial_movie_content.visibility = View.GONE
        text_message_error.text = mess

    }


    override fun onDataChange(data: List<DataRoom>) {
        LogUtils.a(data.size)


    }

    override fun onFetchMovieSuccess(movie: List<Result>) {
        var movieAdapter = NowMovieAdapter();
        recycle_view.apply {
            layoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            movieAdapter.setNowPlayingMovies(movie)
            adapter = movieAdapter

            setHasFixedSize(true)
        }
        var snapHelper = StartSnapHelper()
        snapHelper.attachToRecyclerView(recycle_view)
    }

    override fun onFetchMostPopularSuccess(movie: List<Result>) {
        var popularAdapter = MostPopularAdapter()

        recycle_view_most_popular.apply {
            layoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL,
                false
            )
            popularAdapter.setMostPopulars(movie)
            adapter = popularAdapter
            isNestedScrollingEnabled = false //disable nested scroll of recycleview
            setHasFixedSize(true)

        }
        popularAdapter.setPopularClickItemListener(this)


    }

    override fun onPopularItemClick(movieId: Int) {
        val bundle = Bundle()
        bundle.putString(Common.ARGUMENT_MOVIE, movieId.toString())
        findNavController().navigate(R.id.detailFragment, bundle)
    }
}
