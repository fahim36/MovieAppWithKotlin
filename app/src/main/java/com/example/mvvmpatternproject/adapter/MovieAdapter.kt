package com.example.mvvmpatternproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmpatternproject.R
import com.example.mvvmpatternproject.data.ApiUrls
import com.example.mvvmpatternproject.data.model.MovieList
import com.example.mvvmpatternproject.databinding.MovieItemBinding

class MovieAdapter(var context: Context) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val movies = mutableListOf<MovieList>()


    inner class MovieViewHolder(private val binding: MovieItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bindData(movie:MovieList){
            //bind data here
            binding.tvMovieName.text=movie.title


            val media = ApiUrls.POSTER_BASE_URL+movie.posterPath
            if (media !== null) {
                Glide.with(context)
                    .load(media)
                    .into(binding.ivMovieImage)
            } else {
                binding.ivMovieImage.setImageResource(R.drawable.ic_launcher_foreground)
            }

        }
    }

    fun addDataToAdapter(movieList:List<MovieList>){
        movies.addAll(movieList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MovieViewHolder {
       val bind = MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(bind)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        holder.bindData(movies[position])
//        holder.itemView.setOnClickListener{
//            val transaction = (context as MainActivity).supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.fragmentContainer, MovieDetailsFragment())
//            transaction.commit()
//        }
    }

    override fun getItemCount(): Int =movies.size
}