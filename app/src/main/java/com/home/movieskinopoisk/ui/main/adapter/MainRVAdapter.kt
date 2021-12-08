package com.home.movieskinopoisk.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.home.movieskinopoisk.BASE_URL_IMAGE_TMDB
import com.home.movieskinopoisk.R
import com.home.movieskinopoisk.IDataModel
import com.home.movieskinopoisk.model_tmdb.data.DataModel
import com.home.movieskinopoisk.IMovie
import com.home.movieskinopoisk.model_tmdb.data.Movie
import com.home.movieskinopoisk.ui.main.OnItemViewClickListener

class MainRVAdapter(private var onItemViewClickListener: OnItemViewClickListener?) :
    RecyclerView.Adapter<MainRVAdapter.ViewHolderOne>() {

    private var filmList: IDataModel = DataModel(movies = listOf(Movie()))

    fun setFilmList(data: IDataModel) {
        filmList = data
        notifyDataSetChanged()
    }

    fun removeListener() {
        onItemViewClickListener = null
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderOne {
        return ViewHolderOne(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.main_fragment_rv_item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: ViewHolderOne, position: Int) {
        holder.bind(filmList.movies.get(position))
    }

    override fun getItemCount(): Int {
        return filmList.movies.size
    }

    inner class ViewHolderOne(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(movie: IMovie?) {
            itemView.findViewById<TextView>(R.id.rating_text).setText(movie?.rating_kinopoisk)
            itemView.findViewById<TextView>(R.id.year_count_text).setText(movie?.year.toString())
            Glide
                .with(itemView.context)
                .load(BASE_URL_IMAGE_TMDB + movie?.poster)
                .into(itemView.findViewById(R.id.rv_image))
            itemView.setOnClickListener(View.OnClickListener {
                onItemViewClickListener?.onItemViewClick(
                    BASE_URL_IMAGE_TMDB + movie?.poster,
                    movie?.title,
                    movie?.description,
                )
            })
            itemView.findViewById<TextView>(R.id.rv_title).setText(movie?.title)
        }
    }
}