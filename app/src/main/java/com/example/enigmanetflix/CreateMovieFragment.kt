package com.example.enigmanetflix

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.fragment.app.activityViewModels
import com.example.enigmanetflix.movie.Movie
import com.example.enigmanetflix.movie.MovieViewModel
import kotlinx.android.synthetic.main.fragment_create_movie.*

/**
 * A simple [Fragment] subclass.
 * Use the [CreateMovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateMovieFragment : Fragment(),View.OnClickListener{

    val movieViewModel by activityViewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitMovie.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v){
            submitMovie -> {
                val movie = Movie(id = movieIdInputText.text.toString(),
                    movieName = movieNameInputText.text.toString(),
                    movieDuration = movieDurationInputText.text.toString(),
                    movieDesc = movieDescInputText.text.toString(),
                    movieImage = movieImageInputText.text.toString())

                if (movieIdInputText.text.toString() == "" ||
                    movieNameInputText.text.toString() == "" ||
                    movieDurationInputText.text.toString() == "" ||
                    movieDescInputText.text.toString() == "" ||
                    movieImageInputText.text.toString() == ""
                ) {
                    makeText(this.context, "Must be Field", LENGTH_SHORT).show()
                } else {
                    movieViewModel.createMovie(movie)
                }
            }
        }
    }
}