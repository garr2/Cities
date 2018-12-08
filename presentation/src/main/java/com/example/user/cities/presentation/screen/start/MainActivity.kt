package com.example.user.cities.presentation.screen.start

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.user.cities.databinding.ActivityMainBinding
import com.example.user.cities.presentation.base.BaseMvvmActivity

class MainActivity : BaseMvvmActivity<MainViewModel,MainRouter,ActivityMainBinding>() {

    override fun provideViewModel(): MainViewModel {
        return ViewModelProders.of(this)
                .get(MainViewModel::class.java)
    }

    override fun provideLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun provideRouter(): MainRouter {
       return MainRouter(this)
    }


}
