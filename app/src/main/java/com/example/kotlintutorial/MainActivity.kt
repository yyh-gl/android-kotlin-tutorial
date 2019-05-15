package com.example.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.LinkedList


class MainActivity : AppCompatActivity() {
    private val mWordList = LinkedList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0..19) {
            mWordList.addLast("Word $i")
        }
    }

}
