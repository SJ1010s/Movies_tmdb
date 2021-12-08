package com.home.movieskinopoisk.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.home.movieskinopoisk.AppState
import com.home.movieskinopoisk.R
import com.home.movieskinopoisk.databinding.MainFragmentBinding
import com.home.movieskinopoisk.ui.description.DescriptionFragment
import com.home.movieskinopoisk.ui.main.adapter.MainRVAdapter

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _viewBinding: MainFragmentBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: MainViewModel
            by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    private var adapter: MainRVAdapter? = null

    private val onItemViewClickListener: OnItemViewClickListener =
        object : OnItemViewClickListener {
            override fun onItemViewClick(poster: String?, title: String?, description: String?) {
                val fragment = DescriptionFragment.newInstance(poster, title, description)
                val fragmentManager = requireActivity().supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction
                    .setReorderingAllowed(true)
                    .add(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit()

                Toast.makeText(context, title, Toast.LENGTH_SHORT).show()
            }

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = MainFragmentBinding.inflate(layoutInflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRV()
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getFilmFromRemoteSource()
    }

    private fun initRV() {
        viewBinding.rvFilms.layoutManager = GridLayoutManager(context, 2)
        adapter = MainRVAdapter(onItemViewClickListener)
        viewBinding.rvFilms.adapter = adapter
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                viewBinding.loadingLayout.visibility = View.GONE
                adapter?.setFilmList(appState.data)
            }
            is AppState.Loading -> {
                viewBinding.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                viewBinding.loadingLayout.visibility = View.GONE
                Log.d("ServerError", "renderData: ${appState.errorS}")
                Snackbar
                    .make(
                        viewBinding.mainView,
                        getString(R.string.error),
                        Snackbar.LENGTH_INDEFINITE
                    )
                    .setAction(getString(R.string.reload)) { viewModel.getFilmFromRemoteSource() }
                    .show()
            }
            else -> {}
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}