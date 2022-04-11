package com.example.returnkotlin.di

import com.example.returnkotlin.constant.ApiConstant
import com.example.returnkotlin.repo.PublicHolidayRepository
import com.example.returnkotlin.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofit() : Retrofit = Retrofit.Builder()
        .baseUrl(ApiConstant.API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideService(retrofit: Retrofit) : ApiService = retrofit.create(ApiService::class.java)

}