package com.ritika.recyclerview

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
class MyAdapter(var newsArrayList: ArrayList<News>, var context: Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
        private lateinit var myListner:onItemClickListner

        interface onItemClickListner{
            fun onItemClick(position: Int)

        }
    fun setItemClickListner(listner: onItemClickListner){
        myListner=listner
    }

    //To create new view instance when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(itemView,myListner)
    }

    //populate items with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem=newsArrayList[position]
        holder.h_title.text=currentItem.newsHeading
        holder.h_img.setImageResource(currentItem.newsImage)
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }
    class MyViewHolder(itemView: View,listner: onItemClickListner) :RecyclerView.ViewHolder(itemView){
        val h_title=itemView.findViewById<TextView>(R.id.card_heading)
        val h_img=itemView.findViewById<ShapeableImageView>(R.id.card_image)

        init {
            itemView.setOnClickListener {
              listner.onItemClick(adapterPosition)
            }
        }
    }


}
