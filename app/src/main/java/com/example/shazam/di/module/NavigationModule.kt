package com.example.shazam.di.module

import com.example.shazam.android.system.ActivityContextHolder
import com.example.shazam.navigation.AppNavComponentsNavigator
import com.example.shazam.navigation.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class NavigationModule {
    @Provides
    fun provideNavigator(contextHolder: ActivityContextHolder): Navigator =
            AppNavComponentsNavigator(contextHolder)
}