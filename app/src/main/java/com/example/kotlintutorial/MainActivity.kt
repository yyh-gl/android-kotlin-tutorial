package com.example.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.content.Intent
import android.widget.EditText
import android.widget.TextView
import android.R.attr.data









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

        mMessageEditText = findViewById(R.id.editText_main)

        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)
    }

    // startActivityForResult() を使って遷移した先から
    // result が返ってきたときに発火
    public override fun onActivityResult(requestCode: Int,
                                         resultCode: Int,
                                         data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply = data?.getStringExtra(SecondActivity.EXTRA_REPLY)
                mReplyHeadTextView?.visibility = View.VISIBLE
                mReplyTextView?.text = reply
                mReplyTextView?.visibility = View.VISIBLE
            }
        }
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")

        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText?.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)

        // 終わったら result 返してねっていうお願い付きの activity遷移
        // TEXT_REQUEST でどのリクエストなのか区別する
        startActivityForResult(intent, TEXT_REQUEST)
    }

}
