package com.example.user.cities.presentation.screen.start.cityGameFragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.user.cities.R
import com.example.user.cities.databinding.FragmentHelloBinding
import com.example.user.cities.presentation.base.BaseMVVMFragment
import com.example.user.cities.presentation.screen.start.MainRouter

/**
 * Created by user on 08.12.2018.
 */
class CityLogoFragment : BaseMVVMFragment<CityLogoViewModel,MainRouter,FragmentHelloBinding>() {


    companion object {
        fun getInstance(): CityLogoFragment {
            return CityLogoFragment()
        }
    }


    override fun provideViewModel(): CityLogoViewModel {
       return ViewModelProviders.of(this).get(CityLogoViewModel::class.java)

    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_hello
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var buttonGo: Button = view.findViewById(R.id.buttonGoTo)

        buttonGo.setOnClickListener(View.OnClickListener {
            router?.goToCityGame()

        })
    }
}