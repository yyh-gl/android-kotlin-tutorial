package com.example.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText
import android.content.Intent
import android.view.View

class SecondActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_REPLY = "com.example.kotlintutorial.extra.REPLY"
    }

    private var mReply: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message: String = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        val textView: TextView? = findViewById(R.id.text_message)
        textView?.text = message

        mReply = findViewById(R.id.editText_second)
    }

    fun returnReply(view: View) {
        val reply = mReply?.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)

        // startActivityForResult() で呼び出されているので
        // 処理が終わったら result をセットして finish() してあげる
        setResult(RESULT_OK, replyIntent)
        finish()
    }
}
