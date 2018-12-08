package com.example.user.cities.data.repositories

import com.example.user.cities.data.JsonService
import com.example.user.cities.data.entity.transformToDomain
import com.example.user.cities.domain.entity.City
import com.example.user.cities.domain.repositories.CityRepository
import io.reactivex.Observable

class CityRepositoryImp(val jsonService: JsonService) : CityRepository {


    override fun get(): Observable<List<City>> {
        return jsonService.execute().map {
            it.map {
                it.transformToDomain()
            }
        }
    }

}