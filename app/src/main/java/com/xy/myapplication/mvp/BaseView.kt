package com.xy.myapplication.mvp

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError()
}