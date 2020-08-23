package com.example.enigmanetflix

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.enigmanetflix.adapter.MovieRecycleAdapter
import com.example.enigmanetflix.movie.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie_list.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [MovieListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieListFragment : Fragment() {

    private val movieViewModel by activityViewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movie_recycle_view.layoutManager = LinearLayoutManager(activity)

        movieViewModel.allMovie.observe(viewLifecycleOwner, androidx.lifecycle.Observer{
            movie_recycle_view.adapter = MovieRecycleAdapter(it,activity)
        })
        movieViewModel.getAllMovie()

    }
}