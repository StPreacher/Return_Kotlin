package com.example.returnkotlin.di

import android.content.Context
import com.example.returnkotlin.util.StringHelper
import com.example.returnkotlin.util.ToastHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HelperModule {

    @Provides
    fun provideStringHelper(@ApplicationContext context : Context) : StringHelper = StringHelper(context)

    @Provides
    fun provideToastHelper(@ApplicationContext context: Context) : ToastHelper = ToastHelper(context)
}