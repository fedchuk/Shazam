package com.example.shazam.ui.main

import androidx.activity.viewModels
import com.example.shazam.R
import com.example.shazam.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel>(R.layout.activity_main) {
    override val viewModel: MainViewModel by viewModels()
}