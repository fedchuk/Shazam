package com.example.shazam.di

import android.view.View
import androidx.navigation.NavDirections

sealed class NavigationCommand {
    data class ToAction(val actionId: Int) : NavigationCommand()
    data class ToDirections(
        val directions: NavDirections,
        val sharedElements: Map<View, String> = emptyMap()
    ) : NavigationCommand()

    data class To(val directions: Int, val data: Map<*, *>? = null) : NavigationCommand()
    object Back : NavigationCommand()
    data class BackTo(val destinationId: Int, val inclusive: Boolean) : NavigationCommand()
}
