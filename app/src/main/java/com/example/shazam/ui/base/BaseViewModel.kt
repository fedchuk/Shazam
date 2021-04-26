package com.example.shazam.ui.base

import androidx.lifecycle.ViewModel
import com.example.shazam.di.ErrorHandler

abstract class BaseViewModel(protected val errorHandler: ErrorHandler) : ViewModel() {
}