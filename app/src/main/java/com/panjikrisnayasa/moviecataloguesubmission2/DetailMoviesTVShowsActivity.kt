package com.panjikrisnayasa.moviecataloguesubmission2

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movies_tvshows.*
import java.util.*

class DetailMoviesTVShowsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIES = "extra_movies"
        const val EXTRA_TVSHOWS = "extra_tvshows"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movies_tvshows)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        image_detail_movies_tvshows_poster.clipToOutline = true

        val detailMovies = intent.getParcelableExtra<MoviesModel>(EXTRA_MOVIES)
        val detailTVShows = intent.getParcelableExtra<TVShowsModel>(EXTRA_TVSHOWS)

        if (detailMovies != null) {
            text_detail_movies_tvshows_duration_runtime_label.text =
                getString(R.string.item_recycler_fragment_movies_text_duration)
            text_detail_movies_tvshows_rating_network_label.text =
                getString(R.string.item_recycler_fragment_movies_text_rating)
            button_detail_movies_tvshows.text =
                getString(R.string.detail_movies_tvshows_button_buy_ticket)
            button_detail_movies_tvshows.setOnClickListener {
                Toast.makeText(
                    this,
                    String.format(
                        getString(R.string.detail_movies_tvshows_toast_buy_ticket),
                        detailMovies.title?.toUpperCase(Locale.getDefault())
                    ),
                    Toast.LENGTH_SHORT
                ).show()
            }

            Glide.with(this)
                .load(detailMovies.poster)
                .into(image_detail_movies_tvshows_poster)
            text_detail_movies_tvshows_title.text = detailMovies.title
            text_detail_movies_tvshows_genre.text = detailMovies.genre
            text_detail_movies_tvshows_duration_runtime.text = detailMovies.duration
            text_detail_movies_tvshows_rating_network.text = detailMovies.rating
            text_detail_movies_tvshows_rating_score.text = detailMovies.ratingScore.toString()
            rating_detail_movies_tvshows_movie.rating = detailMovies.ratingScore / 2
            text_detail_movies_tvshows_synopsis_caption.text = detailMovies.synopsis
        } else if (detailTVShows != null) {
            text_detail_movies_tvshows_duration_runtime_label.text =
                getString(R.string.item_recycler_fragment_tvshows_text_runtime)
            text_detail_movies_tvshows_rating_network_label.text =
                getString(R.string.item_recycler_fragment_tvshows_text_network)
            button_detail_movies_tvshows.text =
                getString(R.string.detail_movies_tvshows_button_watch_now)
            button_detail_movies_tvshows.setOnClickListener {
                Toast.makeText(
                    this,
                    getString(R.string.detail_movies_tvshows_toast_watch_now),
                    Toast.LENGTH_SHORT
                ).show()
            }

            Glide.with(this)
                .load(detailTVShows.poster)
                .into(image_detail_movies_tvshows_poster)
            text_detail_movies_tvshows_title.text = detailTVShows.title
            text_detail_movies_tvshows_genre.text = detailTVShows.genre
            text_detail_movies_tvshows_duration_runtime.text = detailTVShows.runtime
            text_detail_movies_tvshows_rating_network.text = detailTVShows.network
            text_detail_movies_tvshows_rating_score.text = detailTVShows.ratingScore.toString()
            rating_detail_movies_tvshows_movie.rating = detailTVShows.ratingScore / 2
            text_detail_movies_tvshows_synopsis_caption.text = detailTVShows.synopsis
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
