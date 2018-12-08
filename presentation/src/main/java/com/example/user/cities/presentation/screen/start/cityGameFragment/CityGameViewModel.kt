package com.example.user.cities.presentation.screen.start.cityGameFragment

import android.databinding.ObservableField
import com.example.user.cities.presentation.base.BaseViewModel
import com.example.user.cities.presentation.screen.start.MainRouter

/**
 * Created by user on 08.12.2018.
 */
class CityGameViewModel: BaseViewModel<MainRouter>() {

    companion object {
        const val dict = "цукенгшщзхфывапролджэячсмитбю"
    }

    val cityList = HashSet<String>()

    val score = ObservableField<String>("Score: 0")
    val timeOfGame = ObservableField<String>("Time: 0:00:00")
    val iiAnswer = ObservableField<String>("")
    val errorTetxt = ObservableField<String>("Начинайте игру.")

    val playerAnswer = ObservableField<String>("")

    fun onOkClick(){
        removeInArr(playerAnswer.get())
    }

    fun onHintClick(){
       val hintedCity = iiAnswer.get().substring(iiAnswer.get().length - 1)
        playerAnswer.set(hintedCity)
    }

    fun onEndGameClick(){

    }

    private fun removeInArr(answer: String){
        if (cityList.contains(answer)){
            cityList.remove(answer)
            stopTimer()
            iiStep(answer)
        }else{
            errorTetxt.set("Такого города нет.")
        }
    }

    private fun iiStep(currentCity: String){
        var iiAnswer: String
        val lastCharacter = currentCity.substring(currentCity.length - 1)
        iiAnswer = getCity(lastCharacter)
        if (iiAnswer.isEmpty()){
            playerWin()
        }else endIiStep(iiAnswer)
    }

    private fun getCity(lastCharacter: String): String{
        val iterator = cityList.iterator()
        while (iterator.hasNext()){
            val tempCity = iterator.next()
            if (tempCity.startsWith(lastCharacter,true)){
               return tempCity
            }
        }
        return ""
    }

    private fun endIiStep(city: String){
        removeInArr(city)
        iiAnswer.set(city)
        startTimer()
    }

    private fun startTimer(){

    }

    private fun stopTimer(){

    }

    private fun  playerWin(){
        errorTetxt.set("ВЫ ВЫИГРАЛИ!)))")
    }

    /*private fun getRandomChar(): Char{
        return Rand
    }*/
}