package com.example.user.cities.presentation.base

import android.support.v4.app.FragmentManager
import android.widget.Toast

abstract class BaseRouter<A: BaseActivity>(val activity: A){

    fun goBack(){
        activity.onBackPressed()
    }

    fun shhowError(e: Throwable){

        Toast.makeText(activity,e.message, Toast.LENGTH_SHORT).show()
    }
    fun replaceFragment(fragmentManager: FragmentManager
                        , fragment: BaseFragment, containerResId: Int, addToBackstack: Boolean = false){
        var fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(containerResId,fragment,
                fragment::class.java.canonicalName)

        if(addToBackstack){
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commit()
    }

}