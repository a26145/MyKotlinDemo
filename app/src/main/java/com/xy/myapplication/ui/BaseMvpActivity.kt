package com.xy.myapplication.ui

import com.xy.myapplication.base.BaseActivity
import com.xy.myapplication.mvp.BasePresenter
import com.xy.myapplication.mvp.BaseView

open class BaseMvpActivity<T:BasePresenter<*>>:BaseActivity(),BaseView {

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError() {
    }

    lateinit var mPresenter: T

}