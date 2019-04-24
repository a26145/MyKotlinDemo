package com.xy.myapplication.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import cn.jzvd.JzvdStd
//import cn.jzvd.JzvdStd
import com.xy.myapplication.R
import com.xy.myapplication.constant.LordMoreEntity
import com.xy.myapplication.utils.L
import com.xy.myapplication.view.CircleImageView


class XrecyclerAdapter : RecyclerView.Adapter<XrecyclerAdapter.ViewHolder> {
    var mContext: Context
    var videos: List<LordMoreEntity>
    var mInflater: LayoutInflater
    var callback:View.OnClickListener
    //构造
    constructor(context: Context, list: List<LordMoreEntity>,callback:View.OnClickListener) {
        mContext = context
        videos = list
        mInflater = LayoutInflater.from(mContext)
        L.d("adapter")
        this.callback = callback
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val itemView: View = mInflater.inflate(R.layout.item_video, p0,false)
        val holder: ViewHolder = ViewHolder(itemView)
        return holder
    }

    override fun getItemCount(): Int {
        if (videos != null && videos.size > 0) {
            return videos.size
        } else {
            return 0
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var entity = videos.get(position)
        holder.player.setUp(entity.url, entity.desc, JzvdStd.SCREEN_NORMAL)
        holder.logoName.text = "aaaaaaaaaaa"
        L.d("执行了么")

        holder.fxImg.setOnClickListener {
            if (holder.dzRoot.visibility == View.VISIBLE) {
                holder.dzRoot.visibility = View.GONE
            }else{
                holder.dzRoot.visibility = View.VISIBLE
            }
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var player: JzvdStd = itemView.findViewById<JzvdStd>(R.id.detail_player)
        var imageLayout: RelativeLayout = itemView.findViewById(R.id.rl_video_left)
        //        var logoImg : CircleImageView = itemView.findViewById(R.id.iv_video_logo)
        var logoName: TextView = itemView.findViewById(R.id.tv_video_name)
        var logoRoot: RelativeLayout = itemView.findViewById(R.id.rl_video_left)
        var dzRoot: RelativeLayout = itemView.findViewById(R.id.rl_dz)
        var dzImg: ImageView = itemView.findViewById(R.id.iv_video_1)
        var scRoot: RelativeLayout = itemView.findViewById(R.id.rl_sc)
        var scImg: ImageView = itemView.findViewById(R.id.iv_sc)
        var fxRoot: RelativeLayout = itemView.findViewById(R.id.rl_fx)
        var fxImg: ImageView = itemView.findViewById(R.id.iv_fx)
    }
}

