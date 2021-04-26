package com.example.shazam.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.example.shazam.R
import com.example.shazam.android.system.ActivityContextHolder
import com.example.shazam.di.NavigationCommand
import javax.inject.Inject

class AppNavComponentsNavigator @Inject constructor(private val activity: ActivityContextHolder) : Navigator {
    override fun navigate(command: NavigationCommand, controllerId: Int) {
        activity.getContext()?.findNavController(controllerId)?.let { navController ->
            when(command) {
                NavigationCommand.Back -> navController.navigateUp()
                is NavigationCommand.BackTo -> navController.popBackStack(command.destinationId, command.inclusive)
                is NavigationCommand.To -> navController.navigateAnim(command.directions)
                is NavigationCommand.ToAction -> navController.navigate(command.actionId)
                is NavigationCommand.ToDirections -> {
                    val pairs =
                        command.sharedElements.map { (view, string) ->
                            Pair(view, string)
                        }.toTypedArray()
                    val extras = FragmentNavigatorExtras(*pairs)
                    navController.navigate(command.directions, extras)
                }
            }
        }
    }

    fun NavController.navigateAnim(
        @IdRes resId: Int,
        bundle: Bundle? = null,
        whereToPopUp: Int? = null,
        popUpInclus: Boolean = true
    ) {
        val builder = NavOptions.Builder()
            .setEnterAnim(R.anim.nav_default_enter_anim)
            .setExitAnim(R.anim.nav_default_exit_anim)
            .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
            .setPopExitAnim(R.anim.nav_default_pop_exit_anim)

        if (whereToPopUp != null)
            builder.setPopUpTo(whereToPopUp, popUpInclus)
        navigate(resId, bundle, builder.build())
    }
}