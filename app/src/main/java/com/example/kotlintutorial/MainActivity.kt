package com.example.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.content.Intent
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MESSAGE: String = "com.example.kotlintutorial.extra.MESSAGE"
        const val TEXT_REQUEST: Int = 1
    }

    private val LOG_TAG: String = MainActivity::class.java.simpleName

    private var mMessageEditText: EditText? = null
    private var mReplyHeadTextView: TextView? = null
    private var mReplyTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(LOG_TAG, "1===============")
        Log.d(LOG_TAG, "1onCreate")
        Log.d(LOG_TAG, "1===============")

        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)

        val isVisible: Boolean? = savedInstanceState?.getBoolean("reply_visible")
        isVisible?.let {
            mReplyHeadTextView?.visibility = View.VISIBLE
            mReplyTextView?.text = savedInstanceState.getString("reply_text")
            mReplyTextView?.visibility = View.VISIBLE
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "1===============")
        Log.d(LOG_TAG, "1onStart")
        Log.d(LOG_TAG, "1===============")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "1===============")
        Log.d(LOG_TAG, "1onResume")
        Log.d(LOG_TAG, "1===============")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "1===============")
        Log.d(LOG_TAG, "1onStop")
        Log.d(LOG_TAG, "1===============")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "1===============")
        Log.d(LOG_TAG, "1onDestroy")
        Log.d(LOG_TAG, "1===============")
    }

    // startActivityForResult() を使って遷移した先から
    // result が返ってきたときに発火
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(LOG_TAG, "1===============")
        Log.d(LOG_TAG, "1onActivityResult")
        Log.d(LOG_TAG, "1===============")

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply = data?.getStringExtra(SecondActivity.EXTRA_REPLY)
                mReplyHeadTextView?.visibility = View.VISIBLE
                mReplyTextView?.text = reply
                mReplyTextView?.visibility = View.VISIBLE
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(LOG_TAG, "1===============")
        Log.d(LOG_TAG, "1onSaveInstantState")
        Log.d(LOG_TAG, "1===============")

        if (mReplyHeadTextView?.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", mReplyTextView?.text.toString())

        }
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")

        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText?.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)

        // 終わったら result 返してねっていうお願い付きの activity遷移
        startActivityForResult(intent, TEXT_REQUEST)
    }

}
