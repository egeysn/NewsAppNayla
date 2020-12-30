package com.egesoftware.newsappnayla.ui.favorites

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.egesoftware.newsappnayla.databinding.FragmentFavoriteBinding
import com.egesoftware.newsappnayla.ui.adapter.FavoritesAdapter



class FavoritesFragment : Fragment() {

    private lateinit var viewModel: FavoritesViewModel
    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var mContext: Context
    private lateinit var adapter: FavoritesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(inflater, container, false).apply {
            viewModel = ViewModelProvider(this@FavoritesFragment).get(FavoritesViewModel::class.java)
            setLifecycleOwner(viewLifecycleOwner)
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        viewModel.getFavoriteList(mContext)!!.observe(viewLifecycleOwner, Observer {
            adapter.updateList(it)
        })

    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


    private fun setupAdapter() {
        adapter = FavoritesAdapter(viewModel.favNewList, mContext)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.fragmentFavoriteRecycler.layoutManager = layoutManager
        binding.fragmentFavoriteRecycler.adapter = adapter

    }


}