package com.example.user.cities.presentation.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

}
