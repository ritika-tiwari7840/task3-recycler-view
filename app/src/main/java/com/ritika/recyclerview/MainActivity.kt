package com.ritika.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    lateinit var myRecyclerView:RecyclerView
    lateinit var newsArrayList:ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


            myRecyclerView=findViewById(R.id.recycler_view)
        val newsImageArray= arrayOf(
            R.drawable.news,
                    R.drawable.news1,
                    R.drawable.news3,
            R.drawable.news4,
            R.drawable.news5,
            R.drawable.news6 )


val newsHeading= arrayOf(
    "Steve Bannon, a former strategist for Donald Trump, will be released from prison next week after serving four months behind bars for contempt of Congress \n \n Visit: https://www.bbc.com/news/live/cpdqw2yd00dt",
    "Musk is giving some US voters $1m. Is it legal? \n \n Visit: https://www.bbc.com/news/articles/ced0d1g5zyno",
    "Ex-president of Peru gets 20 years for corruption \n \n Visit : https://www.bbc.com/news/articles/cx252e2q055o",
    "US to curb AI investment in China soon \n \n Visit : https://www.reuters.com/technology/artificial-intelligence",
    "Microsoft to let clients build AI agents for routine tasks from November \n \n Visit : https://www.reuters.com/technology/artificial-intelligence",
    "US unveils new rules to block China, Russia and Iran from accessing bulk US data  \n\n Visit : https://www.reuters.com/technology/artificial-intelligence"
)

        myRecyclerView.layoutManager=LinearLayoutManager(this)
        newsArrayList= arrayListOf<News>()
        for(index in newsImageArray.indices){

            val news =News(newsHeading[index],newsImageArray[index])

            newsArrayList.add(news)
        }

        myRecyclerView.adapter=MyAdapter(newsArrayList,this)


    }
}