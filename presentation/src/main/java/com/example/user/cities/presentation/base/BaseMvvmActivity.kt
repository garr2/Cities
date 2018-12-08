package com.example.user.cities.presentation.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import com.example.user.cities.BR
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseMvvmActivity<VM : BaseViewModel<R>,
        R : BaseRouter<*>,
        B : ViewDataBinding> : BaseActivity() {

    protected lateinit var viewModel : VM
    protected lateinit var binding: B
    lateinit var router: R

    protected val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    abstract fun provideViewModel() : VM

    abstract fun provideLayoutId() : Int

    abstract fun provideRouter() : R

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = provideViewModel()

        binding = DataBindingUtil.setContentView(this,provideLayoutId())
        binding.setVariable(BR.view_model,viewModel)

        router= provideRouter()

    }

    protected fun addToDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    override fun onResume() {
        super.onResume()

        viewModel.addRouter(router)
    }

    override fun onPause() {
        super.onPause()
        viewModel.removeRouter()
    }


}