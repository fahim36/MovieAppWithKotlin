package com.example.mvvmpatternproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpatternproject.adapter.MovieAdapter
import com.example.mvvmpatternproject.adapter.MoviePagerAdapter
import com.example.mvvmpatternproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val movieViewModel: MovieViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val movieAdapter: MovieAdapter by lazy {
        MovieAdapter(this)
    }
    private val moviePagerAdapter: MoviePagerAdapter by lazy {
        MoviePagerAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            val gridLayoutManager: RecyclerView.LayoutManager =
                GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            layoutManager = gridLayoutManager
            adapter = moviePagerAdapter
        }
        movieViewModel.movies.observe(this) {
            moviePagerAdapter.submitData(this.lifecycle, it)
        }

//        movieViewModel.movies.apply {
//            when {
//                loadState.refresh is LoadState.Loading -> {
//                    progressBar.value = true
//                }
//                loadState.append is LoadState.Loading -> {
//                    progressBar.value = true
//                }
//                loadState.append is LoadState.NotLoading -> {
//                    progressBar.value = false
//                }
//            }
//        }

    }

//    private fun getDataFromAPI() {
//        binding.textView.setOnClickListener{
//          movieViewModel.getMovie()
//        }
//        movieViewModel.movie.observe(this){
//            when(it){
//                is DataState.Loading->{
//                    Timber.e("Loading")
//                    binding.progressbar.show()
//                }
//                is  DataState.Success->{
//                    Timber.e(it.data.movieLists.first().title)
//                //    moviePagerAdapter.submitData(viewLifecycleOwner.lifecycle, it.data.movieLists)
//                    movieAdapter.addDataToAdapter(it.data.movieLists)
//                    binding.progressbar.hide()
//                }
//                is  DataState.Error->{
//                    Timber.e("Error")
//                    binding.progressbar.hide()
//                }
//            }
//        }
//    }


}