package com.example.user.cities.presentation.screen.start.cityGameFragment

import android.arch.lifecycle.ViewModelProviders
import com.example.user.cities.databinding.CityGameFragmentBinding
import com.example.user.cities.presentation.base.BaseMVVMFragment
import com.example.user.cities.presentation.screen.start.MainRouter

/**
 * Created by user on 08.12.2018.
 */
class CityGameFragment: BaseMVVMFragment<CityGameViewModel,MainRouter,CityGameFragmentBinding>() {
    override fun provideViewModel(): CityGameViewModel {
        return ViewModelProviders.of(this)
                .get(CityGameViewModel::class.java)
    }

    override fun provideLayoutId(): Int {
       return R.layout.city_game_fragment
    }
}