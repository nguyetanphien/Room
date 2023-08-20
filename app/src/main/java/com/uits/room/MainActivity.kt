package com.uits.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uits.room.Database.Entities.RecentHistory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var mainViewModel: MainViewModel

        mainViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(application)
        )[MainViewModel::class.java]

        val recentHistory = RecentHistory()
        recentHistory.id = "1"
        recentHistory.images =
            "https://th.bing.com/th/id/R.6890c58344eb146bc1ec0d40b27e356f?rik=wQULtPjtBD6PiA&pid=ImgRaw&r=0"
        recentHistory.name = "1234"
        recentHistory.title = "nhac"
        mainViewModel.insert(recentHistory)

        mainViewModel.allRecentHistorys.observe(this, Observer { list ->
            list.forEach {
                print(it.id)
                print(it.name)
                print(it.title)

            }
        })
//        Log.d("pppp", mainViewModel.allRecentHistory.value.toString())

    }

}