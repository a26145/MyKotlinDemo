package com.xy.myapplication.ui

import android.os.Bundle
import com.xy.myapplication.base.BaseActivity
import com.xy.myapplication.R
import com.xy.myapplication.mvp.presenter.RegisterPresenter
import com.xy.myapplication.mvp.view.RegisterView
import kotlinx.android.synthetic.main.activity_regist.*

class RegistActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    /**
     * 注册
     */
    override fun onRegisterResult(boolean: Boolean) {
        showToastShort("""注册成功了么$boolean""")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)
        initPresenter()
        initSnackBar()
        doEvent()

    }

    private fun initSnackBar() {
//        var snackbar:Snackbar = Snackbar.make(coordinatorLayout, "我是Snackbar...", Snackbar.LENGTH_LONG);
        //设置Snackbar背景
//        snackbar.getView().setBackgroundResource(R.color.colorPrimary);
//        snackbar.show();
////显示带Action的Snackbar
//        snackbar.setAction("取消", new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //关闭Snackbar
//                snackbar.dismiss();
//            }
//        });

    }

    private fun doEvent() {
        btnTest6.setOnClickListener {
            //            showToastShort("注册")
            mPresenter.register("123", "456","789")
        }
    }

    private fun initPresenter() {
        mPresenter = RegisterPresenter()
        mPresenter.mView = this

    }
}