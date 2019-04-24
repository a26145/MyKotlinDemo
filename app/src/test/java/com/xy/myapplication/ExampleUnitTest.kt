package com.xy.myapplication

import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import org.junit.Test

import org.junit.Assert.*
import java.lang.Exception

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun rxTest001() {
        //Observable是最为常用的数据源，Observable对象提供了常用的创建方法,create,just,from等方法
        Observable.just("hello")
        Observable.fromArray(arrayOf(1, 2, 3, 4, 5))
        Observable.create(ObservableOnSubscribe<String> { t ->
            try {
                t.onNext("Hello")
            } catch (e: Exception) {
                t.onError(e)
            }
        })
//        Completable

//        Completable数据源只会触发onComplete和onError回调，通过from()方法可以创建Completable数据源

    }
    @Test
    fun test002(){
        Observable.just(1,2,3,4)
            .filter {  it > 2 }
            .subscribeBy(onNext = { println(it)})
    }

    @Test
    fun test003(){
        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
        list.toObservable()
            .filter{it.length>=5}
            .subscribeBy(
                onNext = { println(it)},
                onError = {it.printStackTrace()},
                onComplete = { print("Done!")}
            )
    }
}
