package com.home.movieskinopoisk.ui.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.home.movieskinopoisk.databinding.DescriptionFragmentBinding
import com.home.movieskinopoisk.databinding.MainFragmentBinding

class DescriptionFragment: Fragment() {
    companion object{
        private const val POSTER_KEY = "poster_key"
        private const val TITLE_KEY = "title_key"
        private const val DESCR_KEY = "description_key"
        fun newInstance(poster: String?, title: String?, description: String?): Fragment {
            val args = Bundle()
            args.apply {
                putString(POSTER_KEY, poster!!)
                putString(TITLE_KEY, title!!)
                putString(DESCR_KEY, description!!)
            }
            val fragment = DescriptionFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private var _viewBinding: DescriptionFragmentBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = DescriptionFragmentBinding.inflate(layoutInflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide
            .with(requireContext())
            .load(arguments?.getString(POSTER_KEY))
            .into(viewBinding.descriptionImage)
        viewBinding.descriptionTitle.setText(arguments?.getString(TITLE_KEY))
        viewBinding.description.setText(arguments?.getString(DESCR_KEY))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}