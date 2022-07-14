package com.example.asyncexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var startAsyncButton: Button
    lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.asyncTextView)

        startAsyncButton = findViewById(R.id.startAsyncButton)
        startAsyncButton.setOnClickListener(View.OnClickListener {
            startTask()
        })
    }
    fun startTask(){
        textView.text = getString(R.string.napping)
        SimpleAsyncTask(textView).execute()
    }
}