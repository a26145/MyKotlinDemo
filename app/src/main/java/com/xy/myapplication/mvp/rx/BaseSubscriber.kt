package com.xy.myapplication.mvp.rx

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

open class BaseSubscriber<T> : Subscriber<T> {
    override fun onComplete() {
    }

    override fun onSubscribe(s: Subscription?) {
    }

    override fun onNext(t: T) {
    }

    override fun onError(t: Throwable?) {
    }

}