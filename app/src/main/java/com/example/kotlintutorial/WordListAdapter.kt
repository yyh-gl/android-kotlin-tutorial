package com.example.kotlintutorial

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*
import android.view.LayoutInflater


class WordListAdapter(context: Context, wordList: LinkedList<String>) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    private var mWordList: LinkedList<String>? = null
    private var mInflater: LayoutInflater? = null

    init {
        mInflater = LayoutInflater.from(context)
        mWordList = wordList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val mItemView = mInflater?.inflate(
            R.layout.wordlist_item,
            parent, false
        )
        return WordViewHolder(mItemView!!, this)
    }

    override fun getItemCount(): Int {
        mWordList?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val mCurrent = mWordList?.get(position)
        holder.wordItemView?.text = mCurrent
    }

    inner class WordViewHolder(itemView: View, private val mAdapter: WordListAdapter) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var wordItemView: TextView? = null

        init {
            wordItemView = itemView.findViewById(R.id.word)
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            // Get the position of the item that was clicked.
            val mPosition = layoutPosition
            // Use that to access the affected item in mWordList.
            val element = mWordList?.get(mPosition)
            // Change the word in the mWordList.
            mWordList?.set(mPosition, "Clicked! $element")
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged()
        }
    }

}
