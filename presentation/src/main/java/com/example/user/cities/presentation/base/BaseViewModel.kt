package com.example.user.cities.presentation.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel<RO : BaseRouter<*>> : ViewModel() {

    // by lazy ленивая инициализация, объект создастся во время первого обращения
    protected val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    protected var router: RO? = null

    fun addRouter(router: RO?){
        this.router = router
    }

    fun removeRouter(){
        this.router = null
    }

    protected fun addToDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}