package io.github.thang86.themovie.view.fragment.homefragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import io.github.thang86.themovie.BuildConfig
import io.github.thang86.themovie.R
import io.github.thang86.themovie.data.local.model.Result
import kotlinx.android.synthetic.main.item_now_playing_movie.view.*

/**
 *
 * Created by Thang86
 */
class NowMovieAdapter :
    RecyclerView.Adapter<NowMovieAdapter.ViewHolder>() {
    private lateinit var movies: List<Result>
    private lateinit var listener: OnItemNowPlayingClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_now_playing_movie, parent, false)
            .let(::ViewHolder)


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    fun setNowPlayingMovies(movies: List<Result>) {
        this.movies = movies
    }

    override fun getItemCount(): Int = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val imageMovie = itemView.image_avatar_playing_movie!!

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(movie: Result) {
            val imageUrl = BuildConfig.IMAGE_URL.plus(movie.posterPath)
            Picasso.with(itemView.context)
                .load(imageUrl)
                .placeholder(
                    ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.ic_launcher_background
                    )
                )
                .error(
                    ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.ic_launcher_background
                    )
                )
                .into(imageMovie)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener?.onItemNowPlayingClick(movies[position].id.toString()!!)
            }
        }
    }

    interface OnItemNowPlayingClick {
        fun onItemNowPlayingClick(movieId: String);
    }

    public fun setOnItemNowPlayingClick(onItemClick: OnItemNowPlayingClick) {
        this.listener = onItemClick
    }

}