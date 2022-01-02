package com.example.mvvmpatternproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmpatternproject.R
import com.example.mvvmpatternproject.data.ApiUrls
import com.example.mvvmpatternproject.data.model.MovieList
import com.example.mvvmpatternproject.databinding.MovieItemBinding

class MoviePagerAdapter(var context:Context) :

    PagingDataAdapter<MovieList, MoviePagerAdapter.PhotoViewHolder>(PHOTO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

   inner class PhotoViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie:MovieList){
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

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<MovieList>() {
            override fun areItemsTheSame(oldItem: MovieList, newItem: MovieList) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: MovieList, newItem: MovieList) =
                oldItem == newItem
        }
    }


}