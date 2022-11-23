package me.dio.urlshortener.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.dio.urlshortener.domain.ShortenedUrl
import me.dio.urlshortener.databinding.ItemUrlBinding

class UrlsAdapter : ListAdapter<ShortenedUrl, UrlsAdapter.ViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemUrlBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemUrlBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(shortenedUrl: ShortenedUrl) = binding.run {
            tvUrl.text = shortenedUrl.url
            tvOriginalUrl.text = shortenedUrl.original
        }
    }

    class DiffCallBack : ItemCallback<ShortenedUrl>() {
        override fun areItemsTheSame(oldItem: ShortenedUrl, newItem: ShortenedUrl) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: ShortenedUrl, newItem: ShortenedUrl) =
            oldItem == newItem
    }
}