package com.ritika.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var newsArrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recycler_view)

        val newsImageArray = arrayOf(
            R.drawable.news,
            R.drawable.news1,
            R.drawable.news3,
            R.drawable.news4,
            R.drawable.news5,
            R.drawable.news6
        )

        val newsHeading = arrayOf(
            "Steve Bannon, a former strategist for Donald Trump, will be released from prison next week after serving four months behind bars for contempt of Congress \n \n Read More..",
            "Musk is giving some US voters $1m. Is it legal? \n \n Read More..",
            "Ex-president of Peru gets 20 years for corruption \n \n Read More..",
            "US to curb AI investment in China soon \n \n Read More..",
            "Microsoft to let clients build AI agents for routine tasks from November \n \n Read More..",
            "US unveils new rules to block China, Russia and Iran from accessing bulk US data  \n\n Read More.."
        )


        val newsContent = arrayOf(
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content)
        )

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf()

        for (index in newsImageArray.indices) {
            val news = News(newsHeading[index], newsImageArray[index], newsContent[index])
            newsArrayList.add(news)
        }

        val myAdapter = MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = myAdapter

        // Set click listener for the adapter
        myAdapter.setItemClickListner(object : MyAdapter.onItemClickListner {
            override fun onItemClick(position: Int) {
                val intent = Intent(applicationContext, NewsActivity2::class.java)

                // Passing the actual heading and content instead of resource IDs
                intent.putExtra("heading", newsArrayList[position].newsHeading)
                intent.putExtra("imageId", newsArrayList[position].newsImage)
                intent.putExtra("newsContent", newsArrayList[position].newsContent)

                startActivity(intent)
            }
        })
    }
}
