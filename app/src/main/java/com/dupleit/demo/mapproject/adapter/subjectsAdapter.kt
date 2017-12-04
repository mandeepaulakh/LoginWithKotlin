package com.dupleit.demo.mapproject.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.dupleit.demo.mapproject.HelperClasses.Config
import com.dupleit.demo.mapproject.Model.Subject
import com.dupleit.demo.mapproject.R
import kotlinx.android.synthetic.main.card_subjects.view.*

/**
 * Created by mandeep on 8/11/17.
 */
class subjectsAdapter (val userList: ArrayList<Subject>): RecyclerView.Adapter<subjectsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.card_subjects, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val user:Subject = userList[position]
        Glide.with(holder?.itemView?.context).load(Config.Web_path + user.sub_img).into(holder?.tvName)

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvName = itemView.imageSubject


    }

}