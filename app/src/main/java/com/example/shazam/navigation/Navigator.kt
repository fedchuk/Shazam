package com.example.shazam.navigation

import androidx.annotation.IdRes
import com.example.shazam.R
import com.example.shazam.di.NavigationCommand

interface Navigator {
    fun navigate(command: NavigationCommand, @IdRes controllerId: Int = R.id.main_nav_host)
}