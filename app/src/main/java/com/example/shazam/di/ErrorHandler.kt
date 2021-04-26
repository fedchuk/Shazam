package com.example.shazam.di

import timber.log.Timber
import javax.inject.Inject

class ErrorHandler @Inject constructor() {
    fun proceed(error: Throwable) {
        Timber.e(error, "")
    }
}