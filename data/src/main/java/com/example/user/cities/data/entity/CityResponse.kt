package com.example.user.cities.data.entity

import com.google.gson.annotations.SerializedName

class CityResponse(@SerializedName("city_id")
                        val city_id: String,
                        @SerializedName("country_id")
                        val country_id: String,
                        @SerializedName("region_id")
                        val region_id: String,
                        @SerializedName("name")
                        val name: String) : DataEntity {
}
