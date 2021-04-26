package com.example.shazam.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.example.shazam.R

abstract class BaseFragment<VM : BaseViewModel>(@LayoutRes val layoutId: Int) : Fragment(layoutId) {
    protected abstract val viewModel: VM

    @ColorRes
    open val statusBarColor: Int = R.color.white

    protected fun <T> LiveData<T>.observe(function: (T) -> Unit) {
        observe(viewLifecycleOwner, function)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.statusBarColor =
            ContextCompat.getColor(requireContext(), statusBarColor)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}