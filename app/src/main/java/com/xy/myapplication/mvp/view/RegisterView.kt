package com.xy.myapplication.mvp.view

import com.xy.myapplication.mvp.BaseView

interface RegisterView:BaseView {
    fun onRegisterResult(boolean: Boolean)
}