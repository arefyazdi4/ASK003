package com.rfburger.ask003

import androidx.core.util.rangeTo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

class ForecastRepository {

    private val _weeklyForecast = MutableLiveData<List<DailyForecast>>()
    val weeklyForecast: LiveData<List<DailyForecast>> = _weeklyForecast

    fun loadForecast(zipcode : String){
        val randomValues = List(7){ Random.nextFloat().rem(100)*100}
        val forecastItems = randomValues.map { temp1 ->
            DailyForecast(temp1 , getTempDescription(temp1))
        }
        _weeklyForecast.value = forecastItems
    }

    private fun getTempDescription(temp2 : Float) : String{

        return if(temp2 < 75) "its too cold" else "it's great"

//        return when (temp2) {
//            in Float.MIN_VALUE.rangeTo(0f) -> "Any thing below zero doesn't make sense "
//            in 0.rangeTo(32) -> "way too cold"
//            in 32.rangeTo(55) -> "not bad but still cold"
//            in 55.rangeTo(75) -> "partly cloudy"
//            in 75.rangeTo(100) -> "its great"
//            in 100f.rangeTo(Float.MAX_VALUE) -> "sunny day"
//            else -> "not bad , not bad"
//        }
    }

}