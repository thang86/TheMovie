package io.github.thang86.themovie.view.fragment.homefragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import com.squareup.picasso.Picasso
import io.github.thang86.themovie.BuildConfig
import io.github.thang86.themovie.R
import io.github.thang86.themovie.data.local.model.Result
import kotlinx.android.synthetic.main.item_most_popular.view.*

/**
 *
 * Created by Thang86
 */
class MostPopularAdapter :
    RecyclerView.Adapter<MostPopularAdapter.ViewHolder>() {

    private var onItemClick: OnPopularClickListener? = null
    private lateinit var movies: List<Result>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_most_popular, parent, false)
            .let (::ViewHolder )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    fun setMostPopulars(movies: List<Result>) {
        this.movies = movies
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var poster = itemView.image_poster!!
        private var title = itemView.text_movie_title!!
        private var releaseDate = itemView.text_release_date!!
        private var times = itemView.text_times!!
        private var overview = itemView.text_overview!!

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
                .into(poster)

            title.text = movie.title
            releaseDate.text = movie.releaseDate
            times.text = "12:30"
            overview.text = movie.overview
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != NO_POSITION) {
                onItemClick?.onPopularItemClick(movies[position].id!!)
            }

        }
    }

    interface OnPopularClickListener {
        fun onPopularItemClick(movieId: Int)
    }

    fun setPopularClickItemListener(onItemClick: OnPopularClickListener) {
        this.onItemClick = onItemClick
    }


}

