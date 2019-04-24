package com.xy.myapplication.mvp.service

import io.reactivex.Observable

class UserServiceImpl:UserService {
    override fun register(mobile: String, veryfycode: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)
    }
}