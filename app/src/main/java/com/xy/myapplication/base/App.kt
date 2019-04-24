package com.xy.myapplication.base

import android.app.Activity
import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        var activityList = mutableListOf<Activity>()
        fun add(baseActivity: Activity) {
            activityList.add(baseActivity)
        }

        fun dump(baseActivity: Activity) {
            var get = activityList.get(activityList.size - 1)
            activityList.removeAt(activityList.size - 1)
            get.finish()
        }
        fun finishAll(){
            
        }
    }
}