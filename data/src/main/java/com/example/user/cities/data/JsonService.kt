package com.example.user.cities.data

import com.example.user.cities.data.entity.CityResponse
import com.example.user.cities.domain.entity.City
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.stream.JsonReader
import io.reactivex.Observable
import java.io.*
import java.net.URL

class JsonService() {
    val gson = Gson()

    init {
        val gson = GsonBuilder().create()

    }

    @Throws(IOException::class)
    fun execute(): Observable<List<CityResponse>> {
        val reader = JsonReader(FileReader("cities.json"))
        return gson.fromJson(reader, City::class.java)
    }
}