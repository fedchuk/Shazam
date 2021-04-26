package com.example.shazam.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.shazam.android.system.ActivityContextHolder
import javax.inject.Inject

abstract class BaseActivity	<VM : BaseViewModel>(
    @LayoutRes layoutId: Int
) : AppCompatActivity(layoutId) {

    @Inject
    lateinit var contextHolder: ActivityContextHolder

    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contextHolder.insertContext(this)
    }

    override fun onDestroy() {
        contextHolder.clearContext()
        super.onDestroy()
    }
}