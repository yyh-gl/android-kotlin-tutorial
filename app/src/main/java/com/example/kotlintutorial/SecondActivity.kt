package com.example.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText
import android.content.Intent
import android.util.Log
import android.view.View

class SecondActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_REPLY = "com.example.kotlintutorial.extra.REPLY"
    }

    private var mReply: EditText? = null

    private val LOG_TAG: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d(LOG_TAG, "2===============")
        Log.d(LOG_TAG, "2onCreate")
        Log.d(LOG_TAG, "2===============")

        val message: String = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        val textView: TextView? = findViewById(R.id.text_message)
        textView?.text = message

        mReply = findViewById(R.id.editText_second)
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "2===============")
        Log.d(LOG_TAG, "2onStart")
        Log.d(LOG_TAG, "2===============")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "2===============")
        Log.d(LOG_TAG, "2onResume")
        Log.d(LOG_TAG, "2===============")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "2===============")
        Log.d(LOG_TAG, "2onStop")
        Log.d(LOG_TAG, "2===============")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "2===============")
        Log.d(LOG_TAG, "2onDestroy")
        Log.d(LOG_TAG, "2===============")
    }

    fun returnReply(view: View) {
        val reply = mReply?.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)

        // startActivityForResult() で呼び出されているので
        // 処理が終わったら result をセットして finish() してあげる
        setResult(RESULT_OK, replyIntent)
        Log.d(LOG_TAG, "2===============")
        Log.d(LOG_TAG, "2End SecondActivity")
        Log.d(LOG_TAG, "2===============")
        finish()
    }
}
