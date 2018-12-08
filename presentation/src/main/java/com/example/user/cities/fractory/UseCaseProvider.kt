package com.example.user.cities.fractory

import com.example.user.cities.data.JsonService
import com.example.user.cities.data.repositories.CityRepositoryImp
import com.example.user.cities.domain.usecases.GetCityUseCase
import com.example.user.cities.presentation.executor.UIThread

/**
 * Created by user on 08.12.2018.
 */
object UseCaseProvider {

    val uiThread = UIThread()
    var jasonService= JsonService()
    var repository = CityRepositoryImp(jasonService)

    fun provideGetCityUseCase(): GetCityUseCase{
        return GetCityUseCase(uiThread, repository)

    }


}