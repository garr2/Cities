package com.example.user.cities.presentation.factory

import com.example.user.cities.data.JsonService
import com.example.user.cities.data.repositories.CityRepositoryImp
import com.example.user.cities.domain.usecases.GetCityUseCase
import com.example.user.cities.presentation.executor.UIThread

object UseCaseProvider {
    val uiThread = UIThread()
    fun provideCityUseCase(): GetCityUseCase {
        val jsonService = JsonService()
        val repository = CityRepositoryImp(jsonService)
        return GetCityUseCase(uiThread, repository)
    }

}