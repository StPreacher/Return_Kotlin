package com.example.returnkotlin.di

import com.example.returnkotlin.repo.CountryListRepository
import com.example.returnkotlin.repo.PublicHolidayRepository
import com.example.returnkotlin.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providePublicHolidayRepository(apiService: ApiService) : PublicHolidayRepository = PublicHolidayRepository(apiService)

    @Provides
    fun provideCountryListRepository(apiService: ApiService) : CountryListRepository = CountryListRepository(apiService)
}