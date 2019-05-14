package com.example.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var sheepCount = 0 // 追加

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var greeting = "こんにちは"
        val trialTime = Date()
        val calendar = GregorianCalendar()
        calendar.time = trialTime

        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        if (hour in 1..11) {
            greeting = "おはよう"
        } else if (hour > 15) {
            greeting = "こんばんは"
        }

        greeting += "ねむれませんか？"

        textview.text = greeting

        button.setOnClickListener {
            val sheepText = "ひつじが${++sheepCount}匹"
            textview.text = sheepText
        }
    }
}
