package com.example.user.cities.presentation.screen.start.cityGameFragment

import android.databinding.ObservableField
import android.os.CountDownTimer
import com.example.user.cities.presentation.base.BaseViewModel
import com.example.user.cities.presentation.screen.start.MainRouter
import java.util.*

/**
 * Created by user on 08.12.2018.
 */
class CityGameViewModel: BaseViewModel<MainRouter>() {

    companion object {
        private const val dict: String = "цукенгшщзхфывапролджэячсмитбю"
    }

    init {

    }

    private val timer = object : CountDownTimer(3600000,1000){
        override fun onFinish() {
        }

        override fun onTick(p0: Long) {
           updateTimer()
        }

    }

    private var scoreInt = 0
    private var timeSec: Long = 0

    val cityList = HashSet<String>()

    val score = ObservableField<String>("Score: 0")
    val timeOfGame = ObservableField<String>("Time: 0:00:00")
    val iiAnswer = ObservableField<String>("")
    val errorTetxt = ObservableField<String>("Начинайте игру.")

    val playerAnswer = ObservableField<String>("")

    fun onOkClick(){
        removeInArr(playerAnswer.get()!!)
    }

    fun onHintClick(){
        if (!iiAnswer.get()!!.isEmpty()) {
            val hintedCity = iiAnswer.get()!!.substring(iiAnswer.get()!!.length - 1)
            playerAnswer.set(getCity(hintedCity))
        } else {
            playerAnswer.set(getCity(getRandomChar().toString()))
        }

        score.set("Score: ${--scoreInt}")
    }

    fun onEndGameClick(){

    }

    private fun removeInArr(answer: String){
        if (cityList.contains(answer)){
            cityList.remove(answer)
            stopTimer()
            score.set("Score: ${++scoreInt}")
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
        timer.start()
    }

    private fun stopTimer(){
        timer.cancel()
    }

    private fun  playerWin(){
        errorTetxt.set("ВЫ ВЫИГРАЛИ!)))")
    }

    private fun getRandomChar(): Char{
        return dict.elementAt(Random().nextInt(dict.length))
    }

    private fun updateTimer(){
        timeOfGame.set("Time: ${secondToString(++timeSec)}")
    }

    private fun secondToString(seconds: Long): String{
        val tmpTime = seconds%3600
        val hours = seconds/3600
        val minutes = tmpTime/60
        val seconds = tmpTime%60

        return "$hours:$minutes:$seconds"
    }
}