package com.xy.myapplication.mvp

open class BasePresenter<T : BaseView> {

    lateinit var mView: T

}