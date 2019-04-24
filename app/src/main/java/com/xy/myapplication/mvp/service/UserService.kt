package com.xy.myapplication.mvp.service

import io.reactivex.Observable

interface UserService{
    fun register(mobile:String,veryfycode:String,pwd:String):Observable<Boolean>
}