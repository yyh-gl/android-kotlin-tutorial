package com.example.kotlintutorial

import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.view.View


class WordListAdapter : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

}

internal class WordViewHolder : RecyclerView.ViewHolder {
    var wordItemView: TextView? = null
    var mAdapter: WordListAdapter? = null

    fun WordViewHolder(itemView: View, adapter: WordListAdapter) {
        super(itemView)
        wordItemView = itemView.findViewById<View>(R.id.word)
        this.mAdapter = adapter
    }
}




