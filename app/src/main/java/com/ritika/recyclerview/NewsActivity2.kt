package com.ritika.recyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class NewsActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news2)


            val heading =intent.getStringExtra("heading")
            val newsContent=intent.getStringExtra("newsContent")
             val imageId=intent.getIntExtra("imageId",R.drawable.news)



        val headingT=findViewById<TextView>(R.id.detail_heading)
        val imageT=findViewById<ImageView>(R.id.detail_image)
        val contentT=findViewById<TextView>(R.id.newsContent)


        headingT.text=heading
        contentT.text=newsContent
        imageT.setImageResource(imageId)

        }
    }
