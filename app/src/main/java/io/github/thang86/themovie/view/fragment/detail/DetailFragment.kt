package io.github.thang86.themovie.view.fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import io.github.thang86.themovie.BuildConfig
import io.github.thang86.themovie.R
import io.github.thang86.themovie.data.local.model.Result
import io.github.thang86.themovie.data.local.model.detail.MovieDetail
import io.github.thang86.themovie.utils.Common
import io.github.thang86.themovie.view.fragment.homefragment.HomeFragment
import io.github.thang86.themovie.view.fragment.homefragment.HomePresenter
import kotlinx.android.synthetic.main.fragment_detail.*

/**
 *
 * Created by Thang86
 */
class DetailFragment : Fragment(), DetailContract {
    private var movieId: String? = null
    private val presenter: DetailPresenter by lazy { DetailPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieId = it.getString(Common.ARGUMENT_MOVIE)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieId?.let { it1 -> presenter.fetchApiDetailMovie(it1) }
    }

    override fun onFetchDetailMovieSuccess(movie: MovieDetail) {
        val imageUrl = BuildConfig.IMAGE_URL.plus(movie.posterPath)
        val context= context
        Picasso.with(context)
            .load(imageUrl)
            .placeholder(
                context?.let {
                    ContextCompat.getDrawable(
                        it,
                        R.drawable.ic_launcher_background
                    )
                }
            )
            .error(
                context?.let {
                    ContextCompat.getDrawable(
                        it,
                        R.drawable.ic_launcher_background
                    )
                }
            )
            .into(image_poster)
        text_movie_title.text = movie.title
        text_release_date.text = movie.releaseDate
        text_overview.text = movie.overview
    }

    override fun onLoading() {
    }

    override fun onLoadComplete() {
    }

    override fun onError(mess: String) {
    }

    override fun setErrorParent(data: Any) {
    }


}