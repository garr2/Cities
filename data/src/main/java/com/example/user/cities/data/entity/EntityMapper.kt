package com.example.user.cities.data.entity

import com.example.user.cities.domain.entity.City

fun CityResponse.transformToDomain(): City {
    return City(city_id = city_id, name = name)
}

