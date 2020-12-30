package com.egesoftware.newsappnayla.ui.news

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.egesoftware.newsappnayla.databinding.FragmentNewsBinding
import com.egesoftware.newsappnayla.ui.adapter.NewsAdapter
import com.egesoftware.newsappnayla.ui.adapter.NewsAroundTheWorldAdapter
import kotlinx.android.synthetic.main.fragment_news.*
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsFragment : Fragment() {

    private lateinit var binding: com.egesoftware.newsappnayla.databinding.FragmentNewsBinding
    private lateinit var adapter: NewsAdapter
    private lateinit var secondAdapter: NewsAroundTheWorldAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = com.egesoftware.newsappnayla.databinding.FragmentNewsBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            viewmodel = ViewModelProvider(this@NewsFragment).get(NewsViewModel::class.java)
            setLifecycleOwner(viewLifecycleOwner)
        }

        binding.categoryAll.setOnClickListener {
            binding.viewmodel?.fetchLatestNews("world")
            Toast.makeText(context, "World news fetching", Toast.LENGTH_SHORT).show()
            binding.categoryTechnology.cardBackgroundColor
            binding.categorySport
            binding.categoryFinance
            //binding.categoryAll.setCardBackgroundColor(0xFF6200EE) TODO HATA DÜZELTİLECEK

        }
        binding.categoryFinance.setOnClickListener {
            binding.viewmodel?.fetchLatestNews("business")
            Toast.makeText(context, "business news fetching", Toast.LENGTH_SHORT).show()
        }
        binding.categorySport.setOnClickListener {
            binding.viewmodel?.fetchLatestNews("sport")

            Toast.makeText(context, "Sport news fetching", Toast.LENGTH_SHORT).show()
        }
        binding.categoryTechnology.setOnClickListener {
            binding.viewmodel?.fetchLatestNews("technology")
            Toast.makeText(context, "technology news fetching", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("onViewCreated in NewsFragment")
        //binding.viewmodel?.fetchRepoList()
        binding.viewmodel?.fetchWorldNews()
        binding.viewmodel?.fetchLatestNews("business")

        setupAdapter()
        setupObservers()
    }

    private fun setupObservers() {

        binding.viewmodel?.worldNewsLive?.observe(viewLifecycleOwner, {
            secondAdapter.updateNewsList(it)

        })

        binding.viewmodel?.latestNewsLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateNewsList(it)
        })

        binding.viewmodel?.toastMessage?.observe(viewLifecycleOwner, Observer {
            Toast.makeText(this.context, "Toast Message", Toast.LENGTH_LONG).show()
        })
    }

    private fun setupAdapter() {
        val viewModel = binding.viewmodel
        if (viewModel != null) {
            adapter = NewsAdapter(binding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            binding.rvLatestNew.layoutManager = layoutManager
            binding.rvLatestNew.adapter = adapter

            secondAdapter = NewsAroundTheWorldAdapter(binding.viewmodel!!)
            val layoutSecondManager =
                GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
            binding.recyclerTwo.layoutManager = layoutSecondManager
            binding.recyclerTwo.adapter = secondAdapter
        }
    }

}


