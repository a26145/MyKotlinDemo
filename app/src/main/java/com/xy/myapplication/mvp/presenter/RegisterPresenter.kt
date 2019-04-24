package com.xy.myapplication.mvp.presenter

import com.xy.myapplication.ext.excute
import com.xy.myapplication.mvp.BasePresenter
import com.xy.myapplication.mvp.rx.BaseSubscriber
import com.xy.myapplication.mvp.service.UserService
import com.xy.myapplication.mvp.service.UserServiceImpl
import com.xy.myapplication.mvp.view.RegisterView
import com.xy.myapplication.utils.L
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.internal.util.ConnectConsumer
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription


class RegisterPresenter : BasePresenter<RegisterView>() {

    fun register(mobile: String, veryfy: String, pwd: String) {
        var userService: UserService = UserServiceImpl()
//        userService.register(mobile, veryfy, pwd)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe(object : Subscriber<Boolean> {
//                override fun onError(t: Throwable?) {
//                    L.d("出现错误")
//                }
//
//                override fun onComplete() {
//                    L.d("完成")
//                }
//
//                override fun onSubscribe(s: Subscription?) {
//                    L.d("开始观察")
//                }
//
//                override fun onNext(t: Boolean?) {
//                    if (t != null) {
//                        mView.onRegisterResult(t)
//                    }
//                }
//            })
        //二次封装
//        userService.register(mobile, veryfy, pwd)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe(object : BaseSubscriber<Boolean>() {
//                override fun onNext(t: Boolean) {
//                    mView.onRegisterResult(t)
//                }
//            })

        userService.register(mobile,veryfy,pwd)
            .excute(object : BaseSubscriber<Boolean>() {
                override fun onNext(t: Boolean) {
                    mView.onRegisterResult(t)
                }
            })
    }
}

private fun <T> Observable<T>.subscribe(subscriber: Subscriber<T>) {

}
