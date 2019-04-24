package com.xy.myapplication

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.xy.myapplication.adapter.XrecyclerAdapter
import com.xy.myapplication.base.BaseActivity
import com.xy.myapplication.constant.VideoConstant
import com.xy.myapplication.ui.RegistActivity
import com.xy.myapplication.utils.L
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View) {
        val id = v.id
        val model = v.tag
        when(v.id){
            R.id.iv_sc ->{

            }
            R.id.iv_fx->{

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        L.init("测试")
        L.d("执行了么")
        initViews()
    }

    private fun initViews() {
        var list: RecyclerView = findViewById(R.id.rl_list)
        var adapter:XrecyclerAdapter = XrecyclerAdapter(this,VideoConstant.getVideoEntity(),this)
        list.adapter = adapter
        list.layoutManager=LinearLayoutManager(this)
        btnTest3.setOnClickListener {
            startActivity(Intent(this,RegistActivity::class.java))
        }
    }

    /**
     * 横竖屏切换
     */
    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }



}
