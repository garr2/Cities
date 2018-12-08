package com.example.user.cities.presentation.screen.start

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.user.cities.R
import com.example.user.cities.databinding.ActivityMainBinding
import com.example.user.cities.presentation.base.BaseMvvmActivity

class MainActivity : BaseMvvmActivity<MainViewModel, MainRouter, ActivityMainBinding>() {

    override fun provideViewModel(): MainViewModel {
        return ViewModelProviders.of(this).get(MainViewModel::class.java)               //ViewModelProders.of(this)

    }

    override fun provideLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun provideRouter(): MainRouter {
        return MainRouter(this)
    }


}
