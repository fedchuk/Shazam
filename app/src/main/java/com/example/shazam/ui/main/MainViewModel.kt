package com.example.shazam.ui.main

import com.example.shazam.di.ErrorHandler
import com.example.shazam.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(errorHandler: ErrorHandler) : BaseViewModel(errorHandler)