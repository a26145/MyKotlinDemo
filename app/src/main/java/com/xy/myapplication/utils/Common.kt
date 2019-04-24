package com.xy.myapplication.utils

import android.content.Intent

// 数据的存储与获取with(IntentOptions) {
// intent.setMessage("message")
// message = intent.getMessage()}
object IntentOptions {
    private const val MSG_KEY = "key for message"
    fun Intent.getMessage(): String? = getStringExtra(MSG_KEY)
    fun Intent.setMessage(message: String?) {
        putExtra(MSG_KEY, message)
    }
}

class IntentExtraStringDelegate(val key: String) {
//    fun getValue(intent: Intent): String? = intent.getStringExtra(name)
//    fun setValue(intent: Intent, value: String?) {
//        intent.putExtra(name, value)
//    }
}
