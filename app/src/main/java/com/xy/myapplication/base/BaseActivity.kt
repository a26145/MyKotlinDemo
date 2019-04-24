package com.xy.myapplication.base

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import android.provider.Settings
import android.support.v4.app.ActivityCompat


open class BaseActivity : AppCompatActivity() {

    companion object{
        var INSTALL_APK_REQUESTCODE :Int = 999
        var GET_UNKNOWN_APP_SOURCES :Int = 888
    }

    //开始
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * 横竖屏切换
     */
    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }

    /**
     * Toast
     */
    fun showToastShort(str: String) {
        Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()
    }

    /**
     * 跳转
     */
    fun turn2Target(cxt: Context, clazz: Class<Any>) {
        var intent = Intent()
        intent.setClass(cxt, clazz)
        startActivity(intent)
    }

    /**
     * 跳转
     */
    fun turn2TargetForResult(cxt: Context, clazz: Class<Any>, num: Int) {
        var intent = Intent()
        intent.setClass(cxt, clazz)
        startActivityForResult(intent, num)
    }

    fun turn2WebSite(str: String) {
        val uri = Uri.parse(str)
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }


    /**
     * 拨打电话
     */
    fun callTel(tel: String) {
        val uri = Uri.parse("tel:$tel")
        val it = Intent(Intent.ACTION_DIAL, uri)
        startActivity(it)
    }

    /**
     * 调用发短信的程序
     */
    fun sendMsg(name: String, content: String) {
        val it = Intent(Intent.ACTION_VIEW)
        it.putExtra(name, content)
        it.type = "vnd.android-dir/mms-sms"
        startActivity(it)
    }



    fun unstallApk(strPackageName: String) {
        val uri = Uri.fromParts("package", strPackageName, null)
        val it = Intent(Intent.ACTION_DELETE, uri)
        startActivity(it)
    }

    /**
     * <uses-permission android:name="android.permission.REQUEST_INSTALL_PACKAGES" />
     */
    fun installApk() {
        if (Build.VERSION.SDK_INT >= 26) {//8.0
            //来判断应用是否有权限安装apk
            val installAllowed = packageManager.canRequestPackageInstalls()
            //有权限
            if (installAllowed) {
                //安装apk

            } else {
                //无权限 申请权限
                ActivityCompat.requestPermissions(
                    this, arrayOf(Manifest.permission.REQUEST_INSTALL_PACKAGES),
                    INSTALL_APK_REQUESTCODE
                )
            }
        }else{
            //安装apk
            val packageURI = Uri.parse("package:$packageName")//设置包名，可直接跳转当前软件的设置页面
            val intent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, packageURI)
            startActivityForResult(intent, GET_UNKNOWN_APP_SOURCES)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            INSTALL_APK_REQUESTCODE ->{//安装apk

            }
        }
    }
}