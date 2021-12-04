package com.example.task3_6

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class GreetingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)

    val resultMessage = intent.getStringExtra("numberOfClick")
    val number = intent.getStringExtra("numberOfGuess")
    val color = intent.getStringExtra("color")
        findViewById<TextView>(R.id.textViewMessage).text = "$resultMessage"
        findViewById<TextView>(R.id.textViewNumber).text = "$number"
        findViewById<TextView>(R.id.textViewNumber).setTextColor(Color.parseColor("$color"))

    }
}