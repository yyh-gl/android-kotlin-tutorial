package com.example.kotlintutorial

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.view.View


class MainActivity : AppCompatActivity() {
    private val mWordList: LinkedList<String>? = LinkedList()
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: WordListAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            val wordListSize = mWordList?.size
            // Add a new word to the wordList.
            mWordList?.addLast("+ Word $wordListSize")
            // Notify the adapter, that the data has changed.
            if (wordListSize != null) {
                mRecyclerView?.adapter?.notifyItemInserted(wordListSize)
            }
            // Scroll to the bottom.
            if (wordListSize != null) {
                mRecyclerView?.smoothScrollToPosition(wordListSize)
            }
        }

        for (i in 0..9) {
            mWordList?.addLast("Word $i")
        }

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById<View>(R.id.recyclerview) as RecyclerView?
        // Create an adapter and supply the data to be displayed.
        mAdapter = mWordList?.let { WordListAdapter(this, it) }
        // Connect the adapter with the RecyclerView.
        mRecyclerView?.adapter = mAdapter
        // Give the RecyclerView a default layout manager.
        mRecyclerView?.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
