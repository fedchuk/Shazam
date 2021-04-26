package com.example.shazam.di.module

import com.example.shazam.di.ErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class GlobalPresentationModule {
    @Singleton
    @Provides
    fun provideErrorHandler(): ErrorHandler = ErrorHandler()
}