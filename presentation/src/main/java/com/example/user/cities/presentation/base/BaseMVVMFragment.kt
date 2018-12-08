package com.example.user.cities.presentation.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseMVVMFragment<VM : BaseViewModel<R>, R: BaseRouter<*>, binding: ViewDataBinding>: BaseFragment() {

    protected lateinit var viewModel : VM
    protected lateinit var binding: binding
    protected var router: R? = null

    protected val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    abstract fun provideViewModel() : VM

    abstract fun provideLayoutId() : Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

        viewModel = provideViewModel()

        binding = DataBindingUtil.inflate(inflater,provideLayoutId(),container,false)
        binding.setVariable(BR.view_model,viewModel)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity is BaseMvvmActivity<*, *, *>){
            router = (activity as BaseMvvmActivity<*, *, *>).router as R
        }
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