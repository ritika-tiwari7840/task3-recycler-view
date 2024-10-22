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

class MyAdapter(private var newsArrayList: ArrayList<News>, private var context: Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return MyViewHolder(itemView)
    }

    // Populate items with data
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.h_title.text = getClickableSpannableText(currentItem.newsHeading)
        holder.h_img.setImageResource(currentItem.newsImage)
        holder.h_title.movementMethod = LinkMovementMethod.getInstance() // Enable link clicks
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    // Function to make the URLs in the text clickable
    private fun getClickableSpannableText(newsHeading: String): SpannableString {
        val spannableString = SpannableString(newsHeading)


        var startIndex = newsHeading.indexOf("Visit:")
        while (startIndex != -1) {
            val urlStart = startIndex + 7
            val urlEnd = newsHeading.indexOf(' ', urlStart).takeIf { it != -1 } ?: newsHeading.length


            val url = newsHeading.substring(urlStart, urlEnd)
            val clickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    try {
                        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        context.startActivity(browserIntent)
                    } catch (e: Exception) {
                        Toast.makeText(context, "Invalid URL: $url", Toast.LENGTH_SHORT).show()
                    }
                }
            }


            spannableString.setSpan(clickableSpan, startIndex, urlEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


            startIndex = newsHeading.indexOf("Visit:", urlEnd)
        }

        return spannableString
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val h_title: TextView = itemView.findViewById(R.id.card_heading)
        val h_img: ShapeableImageView = itemView.findViewById(R.id.card_image)
    }
}
