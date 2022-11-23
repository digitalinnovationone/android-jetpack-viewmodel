package me.dio.urlshortener.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.dio.urlshortener.databinding.FragmentUrlsBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class UrlsFragment : Fragment() {

    private var _binding: FragmentUrlsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: UrlsViewModel by viewModels {
        ViewModelFactory()
    }

    private val urlsAdapter = UrlsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUrlsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvShortenedUrls.bind()
        viewModel.state.observe(viewLifecycleOwner, ::handleState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun RecyclerView.bind() {
        val linearLayoutManager = layoutManager as LinearLayoutManager
        val divider = DividerItemDecoration(context, linearLayoutManager.orientation)
        addItemDecoration(divider)
        adapter = urlsAdapter
    }

    private fun handleState(state: UrlsState) = binding.run {
        urlsAdapter.submitList(state.urls)
        progress.isVisible = state.isProgressVisible
        tvErrorMessage.text = state.errorMessage
        tvErrorMessage.isVisible = state.isErrorMessageVisible
    }
}