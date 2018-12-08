package com.example.user.cities.domain.usecases

import com.example.user.cities.domain.entity.City
import com.example.user.cities.domain.executor.PostExecutorThread
import com.example.user.cities.domain.repositories.CityRepository
import io.reactivex.Observable

class GetCityUseCase(postExecutorThread: PostExecutorThread,
                     private val cityRepository: CityRepository) : BaseUseCase(postExecutorThread) {
    fun get(): Observable<List<City>> {
        return cityRepository.get().observeOn(postExecutorThread).subscribeOn(workExecutorThread)
    }


}