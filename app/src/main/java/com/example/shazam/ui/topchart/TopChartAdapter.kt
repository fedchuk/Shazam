package com.example.shazam.ui.topchart

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shazam.R
import com.example.shazam.data.model.Artists
import com.example.shazam.data.model.TopChart
import com.example.shazam.databinding.ItemListTopChartBinding

class TopChartAdapter(
    val context: Context
) : PagingDataAdapter<TopChart, TopChartAdapter.TopChartVH>(TopChartComparator) {

    companion object {
        private val AUTHOR_DIVIDER = ", "
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopChartAdapter.TopChartVH {
        val binding = ItemListTopChartBinding.inflate(LayoutInflater.from(parent.context))
        binding.root.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return TopChartVH(binding)
    }

    override fun onBindViewHolder(holder: TopChartAdapter.TopChartVH, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TopChartVH(private val binding: ItemListTopChartBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(topChart: TopChart?) {
            with(binding) {
                Glide.with(binding.ivPoster)
                    .load(topChart?.images?.coverart)
                    .into(binding.ivPoster)
                tvTitle.text = topChart?.title
                tvAuthor.text = String.format(context.getString(R.string.author_name), getAuthors(topChart?.artists))
            }
        }
    }

    object TopChartComparator : DiffUtil.ItemCallback<TopChart>() {
        override fun areItemsTheSame(oldItem: TopChart, newItem: TopChart): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TopChart, newItem: TopChart): Boolean {
            return oldItem == newItem
        }
    }

    private fun getAuthors(artists: List<Artists>?) : String {
        val sb = StringBuffer()
        if (!artists.isNullOrEmpty()) {
            for (a in artists) {
                sb.append(AUTHOR_DIVIDER).append(a.alias)
            }
        }
        return sb.toString().replaceFirst(AUTHOR_DIVIDER, "", false)
    }
}