package com.example.shazam.ui.topchart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shazam.R
import com.example.shazam.databinding.FragmentTopChartBinding
import com.example.shazam.extension.viewBinding
import com.example.shazam.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopChartFragment : BaseFragment<TopChartViewModel>(R.layout.fragment_top_chart) {
    override val viewModel: TopChartViewModel by viewModels()
    private val binding: FragmentTopChartBinding by viewBinding()
    private lateinit var adapter: TopChartAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        lifecycleScope.launch {
            viewModel.listData.collect {
                adapter.submitData(it)
            }
        }
    }

    private fun initUI() {
        adapter = TopChartAdapter(requireContext())
        with(binding) {
            rv.layoutManager = LinearLayoutManager(requireContext())
            rv.adapter = adapter
        }
    }
}