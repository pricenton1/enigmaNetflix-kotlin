package com.example.enigmanetflix.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.enigmanetflix.R
import com.example.enigmanetflix.movie.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_recycle_item_layout.view.*

class MovieRecycleAdapter(private val movieList:List<Movie>,private val getActivity: FragmentActivity?):
    RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_recycle_item_layout,parent,false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieName.text = movieList[position].movieName
        holder.movieDuration.text = movieList[position].movieDuration
        Picasso.with(getActivity).load(movieList[position].movieImage).into(holder.imageMovie)

        val bundle = bundleOf(
            Pair("name", movieList[position].movieName),
            Pair("image", movieList[position].movieImage),
            Pair("idMovie", movieList[position].id),
            Pair("desc", movieList[position].movieDesc)
        )
        holder.itemView.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_movieListFragment_to_detailMovieFragment,bundle)
        }
    }
}

class MovieViewHolder(v: View): RecyclerView.ViewHolder(v){

    val movieName = v.findViewById<TextView>(R.id.movie_name_text)
    val movieDuration = v.findViewById<TextView>(R.id.duration_text)
    val imageMovie: ImageView = v.findViewById(R.id.image_movie)
}