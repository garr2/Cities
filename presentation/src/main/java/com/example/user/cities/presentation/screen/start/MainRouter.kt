package com.example.user.cities.presentation.screen.start

import com.example.user.cities.R
import com.example.user.cities.presentation.base.BaseRouter
import com.example.user.cities.presentation.screen.start.cityGameFragment.CityGameFragment
import com.example.user.cities.presentation.screen.start.cityGameFragment.CityLogoFragment
import kotlinx.android.synthetic.main.activity_main.view.*

/**
 * Created by user on 08.12.2018.
 */
class MainRouter(activity: MainActivity): BaseRouter<MainActivity>(activity) {

    fun goToLogoGame(){
     replaceFragment(activity.supportFragmentManager
             ,CityLogoFragment.getInstance()
             ,R.id.flFragment,false)
    }

    fun goToCitiyGame(){
        replaceFragment(activity.supportFragmentManager,CityGameFragment(),
                R.id.flFragment,false)
    }




}