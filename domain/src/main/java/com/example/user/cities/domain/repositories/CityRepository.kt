package com.example.user.cities.domain.repositories

import com.example.user.cities.domain.entity.City
import io.reactivex.Observable

interface CityRepository : BaseRepository {
    fun get(): Observable<List<City>>
}